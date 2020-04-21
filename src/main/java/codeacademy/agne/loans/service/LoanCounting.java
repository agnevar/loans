/**
 * This service class is used to count monthly records from the loan input
 * that was provided by the user when starting to count a new loan
 */

package codeacademy.agne.loans.service;

import codeacademy.agne.loans.domain.LoanRecord;
import codeacademy.agne.loans.domain.LoanTableRecord;

import java.util.ArrayList;

public class LoanCounting {

    public double yearlyLoanCount(double sum, int interestPercent) {

        /**
         * This method counts the interest that will be added
         * when counting loan table records.
         * Simple, usually used yearly interest counting function.
         */

        double interest = ((sum * interestPercent) / 100) / 12;
        return interest;
    }

    public ArrayList<LoanTableRecord> loanTableCountingNoTax(LoanRecord record) {

        /**
         * This method gets LoanRecord object from front-end when there is no TAX payment
         * and then uses it to calculate monthly records
         * and add them to an arraylist of LoanTableRecord class.
         */

        ArrayList<LoanTableRecord> records = new ArrayList<>();

        for (int i = 0; i < record.getTerm(); i++) {
            LoanTableRecord tableRecord = new LoanTableRecord();

            tableRecord.setMonthNr(i + 1);
            tableRecord.setReturnable(Math.round(((record.getSum() / record.getTerm())) * 100.0) / 100.0);
            tableRecord.setRemainder(Math.round(((record.getSum()
                    - (tableRecord.getRemainder() * (i + 1)))) * 100.0) / 100.0);
            tableRecord.setAddedInterest(Math.round(((yearlyLoanCount((tableRecord.getReturnable()
                    + tableRecord.getRemainder()), record.getLoanPercent()))) * 100.0) /100.0);
            tableRecord.setFinalSum(Math.round(((tableRecord.getReturnable()
                    + tableRecord.getAddedInterest())) * 100.0) / 100.0);

            records.add(tableRecord);
        }
        record.setTable(records);
        return records;


    }

    public ArrayList<LoanTableRecord> loanTableCounting(LoanRecord record) {

        /**
         * This method gets LoanRecord object from front-end
         * and then uses it to calculate monthly records
         * and add them to an arraylist of LoanTableRecord class.
         */

        ArrayList<LoanTableRecord> records = new ArrayList<>();

        for (int i = 0; i < record.getTerm(); i++) {
            LoanTableRecord tableRecord = new LoanTableRecord();

            tableRecord.setMonthNr(i + 1);
            tableRecord.setReturnable((record.getSum() + record.getAgreementTax()) / record.getTerm());
            tableRecord.setRemainder((record.getSum() + record.getAgreementTax())
                    - (tableRecord.getReturnable() * (i + 1)));
            tableRecord.setAddedInterest(yearlyLoanCount((tableRecord.getReturnable()
                    + tableRecord.getRemainder()), record.getLoanPercent()));
            tableRecord.setFinalSum(tableRecord.getReturnable()
                    + tableRecord.getAddedInterest());

            records.add(tableRecord);

        }
        record.setTable(records);
        return records;
    }


    public LoanTableRecord loanTableFinalSums(ArrayList<LoanTableRecord> records) {

        LoanTableRecord record = new LoanTableRecord();
        double returnFinalCount = 0;
        double remainderFinal = 0;
        double addedFinal = 0;
        double totalFinalSum = 0;

        for (int i = 0; i < records.size(); i++) {
            returnFinalCount += records.get(i).getReturnable();
            remainderFinal += records.get(i).getRemainder();
            addedFinal += records.get(i).getAddedInterest();
            totalFinalSum += records.get(i).getFinalSum();
        }
        record.setReturnable(returnFinalCount);
        record.setRemainder(remainderFinal);
        record.setAddedInterest(addedFinal);
        record.setFinalSum(totalFinalSum);

        return record;
    }

}
