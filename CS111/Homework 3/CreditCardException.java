class CreditCardException extends Exception{
   CreditCardException(){
      super("credit card malfunction, transaction cancelled");
   }
   
   CreditCardException(String str){
      super(str);
   }

}


class CreditLimitExceededException extends CreditCardException{
   CreditLimitExceededException(int amountExceeded){
      super("credit limit exceeded by $"+amountExceeded);
   }
}

class FraudulentTranscationException extends CreditCardException{
   FraudulentTranscationException(){
      super("fraudulent transaction");
   }
} 