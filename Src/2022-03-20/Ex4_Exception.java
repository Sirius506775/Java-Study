package org.zerock;

public class Ex4_Exception {


        public void doA () throws Exception {
            doB();
            doC();
        }

        private void doB() throws Exception {
            System.out.println("doB");
        }
        private void doC() throws Exception {
            System.out.println("doC");
        }
    }

