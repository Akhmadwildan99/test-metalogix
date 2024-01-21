package metalogix.test.domain;


// **** **** **** **** START OF DOCUMENT **** **** **** ****
//
// This document is ended when you encounter �END OF DOCUMENT�.
//
// X/Link Software
// Spring Boot Developer Remote Coding Assignment
//
// By reading this document, you are agreed to securely keep this document, and will not distribute it to others.
// If you do not agree, please stop reading and delete this document.
// 1. General information:
//    a. Code must be completed within a week upon receiving remote code assignment.
//    b. When completed, compress final folder that contain Project, Source Code and GIT History using ZIP or RAR.
//    c. Email compressed folder to ahsaputro@gmail.com
// 2. Technical Information:
//    a. API Documentation must be written using Swagger.
//    b. Application must be developed using Java and Spring Boot Framework.
//    c. Application must be coded using NetBeans IDE, minimum version 19.
//    d. Source Code must be committed into GIT source control for every new feature added or every bug fixed for historical review.
//    e. Code must be compileable without any error.
//    f. Code must be runnable in Windows OS and Linux OS according to specification provided in Assignment One and Assignment Two.
// Data source:
//    i. Sample data are provided in Java code in file �Sample.java� (this file).
//   ii. Use the data provided in �Sample.java� to populate and returning JSON Tree in reply.
//  iii. You must use �Sample.java�.
//   iv. You may not ignore �Sample.java�.
//    v. You may not alter any code inside �Sample.java�.
//   vi. The returned JSON tree must be sourced from �Sample.java�.
//
public class Sample {

    public static class Account {

        private final String parentAccountNo;
        private final String accountNo;
        private final int balance;

        private Account(String parentAccountNo, String accountNo, int balance) {
            this.parentAccountNo = parentAccountNo;
            this.accountNo = accountNo;
            this.balance = balance;
        }

        private static Account i(String parentAccountNo, String accountNo, int balance) {
            return new Account(parentAccountNo, accountNo, balance);
        }

        private static Account[] a(Account... accounts) {
            return accounts;
        }

        public String getParentAccountNo() {
            return parentAccountNo;
        }

        public String getAccountNo() {
            return accountNo;
        }

        public int getBalance() {
            return balance;
        }
    }

    public static class SampleAccount {

        private final String sampleName;
        private final String rootAccountNo;
        private final Account[] accounts;

        private SampleAccount(String sampleName, String rootAccountNo, Account[] accounts) {
            this.sampleName = sampleName;
            this.rootAccountNo = rootAccountNo;
            this.accounts = accounts;
        }

        private static SampleAccount i(String sampleName, String rootAccountNo, Account[] accounts) {
            return new SampleAccount(sampleName, rootAccountNo, accounts);
        }

        public String getSampleName() {
            return sampleName;
        }

        public String getRootAccountNo() {
            return rootAccountNo;
        }

        public Account[] getAccounts() {
            return accounts;
        }
    }

    public static SampleAccount[] SAMPLE_ACCOUNTS = new SampleAccount[]{
            SampleAccount.i(
                    "Accounts Sample 1",
                    "0000",
                    Account.a(
                            Account.i("", "0000", 0),
                            Account.i("0000", "0001", 1),
                            Account.i("0000", "0002", 2)
                    )
            ),
            SampleAccount.i(
                    "Accounts Sample 2",
                    "0000",
                    Account.a(
                            Account.i("", "0000", 0),
                            Account.i("0000", "0001", 0),
                            Account.i("0001", "0002", 0),
                            Account.i("0002", "0003", 0),
                            Account.i("0003", "0004", 4)
                    )
            ),
            SampleAccount.i(
                    "Accounts Sample 3",
                    "0000",
                    Account.a(
                            Account.i("", "0000", 0),
                            Account.i("0000", "0001", 0),
                            Account.i("0001", "0002", 20),
                            Account.i("0001", "0003", 30),
                            Account.i("0000", "0004", 0),
                            Account.i("0004", "0005", 50),
                            Account.i("0004", "0006", 0),
                            Account.i("0006", "0007", 0),
                            Account.i("0007", "0008", 80),
                            Account.i("0007", "0009", 90)
                    )
            ),
            SampleAccount.i(
                    "Accounts Sample 4",
                    "000000",
                    Account.a(
                            Account.i("", "000000", 0),
                            Account.i("000008", "000083", 83000),
                            Account.i("000008", "000082", 82000),
                            Account.i("000000", "000001", 0),
                            Account.i("000001", "000011", 0),
                            Account.i("000011", "000111", 111000),
                            Account.i("000011", "000112", 0),
                            Account.i("000112", "001121", 1121000),
                            Account.i("000112", "001122", 1122000),
                            Account.i("000112", "000004", 4000),
                            Account.i("000011", "000113", 113000),
                            Account.i("000092", "000921", 921000),
                            Account.i("000009", "000091", 91000),
                            Account.i("000009", "000092", 0),
                            Account.i("000002", "000009", 0),
                            Account.i("000001", "000012", 12000),
                            Account.i("000001", "000005", 5),
                            Account.i("000000", "000002", 0),
                            Account.i("000002", "000021", 21000),
                            Account.i("000002", "000022", 22000),
                            Account.i("000002", "000006", 0),
                            Account.i("000006", "000061", 0),
                            Account.i("000061", "000611", 0),
                            Account.i("000611", "006111", 6111000),
                            Account.i("000002", "000007", 7000),
                            Account.i("000009", "000008", 8000),
                            Account.i("000008", "000081", 81000)
                    )
            ),
            SampleAccount.i(
                    "Accounts Sample 5",
                    "0",
                    Account.a(
                            Account.i("", "0", 0),
                            Account.i("0", "1", 0),
                            Account.i("1", "11", 0),
                            Account.i("11", "111", 0),
                            Account.i("111", "1111", 1111),
                            Account.i("111", "1112", 1112),
                            Account.i("11", "112", 0),
                            Account.i("112", "1121", 1121),
                            Account.i("112", "1122", 1122),
                            Account.i("1", "12", 0),
                            Account.i("12", "121", 121),
                            Account.i("12", "122", 122),
                            Account.i("0", "2", 0),
                            Account.i("2", "21", 0),
                            Account.i("21", "211", 211),
                            Account.i("21", "212", 212),
                            Account.i("2", "22", 0),
                            Account.i("22", "221", 221),
                            Account.i("22", "222", 222)
                    )
            )
    };
}

//GOOD LUCK, AND HAPPY CODING!!!! ?
// Copyright P.T. Metalogix Infolink Persada, January 2024.
// **** **** **** **** END OF DOCUMENT **** **** **** ****

