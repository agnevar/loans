/**
 * The LoansApplication program implements an application that
 * allows user to count their monthly payments of loans.
 * and displays them in a table view:
 * how big are the monthly payments;
 * how much interest is counted etx.
 *
 * @author  Agne Varanauskiene
 * @version 1.0
 * @since   10-04-2020
 */

package codeacademy.agne.loans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "codeacademy.agne.loans")
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
