
    import static java.lang.Character.getNumericValue;

    public class HexDecBinaryConverter{

        public String decimalToBinary(int decimal){
            if (decimal == 0) return "0"; // Handle zero
            if (decimal < 0) throw new IllegalArgumentException("Negative numbers not supported");
            StringBuilder binary = new StringBuilder();
            while(decimal != 0){
               binary.append(decimal % 2);
               decimal /= 2;
            }
            return binary.reverse().toString();
        }

        public int BinaryToDecimal(String binary){
            int decimal = 0;

            for(int i = binary.length() - 1, j = 0; i >= 0 ; i--, j++){
              if (getNumericValue(binary.charAt(j)) == 1) {
                  decimal += (int) Math.pow(2, i);
              }
            }
            return decimal;
        }
        public int HexToDecimal(String hex){
            int decimal = 0;
            int digit ;
            for(int i = 0; i < hex.length() ; i++){
                char c = Character.toUpperCase(hex.charAt(i));
                if( c >= '0' && c <= '9') digit = c - '0';
                else if(c >= 'A' && c <= 'F') digit = c - 'A' + 10;
                else throw new IllegalArgumentException("Invalid hexadecimal digit: " + c);
                decimal = decimal * 16 + digit;
            }
            return decimal;
        }
        public String DecToHex(int decimal){
            if (decimal == 0) return "0"; // Handle zero
            if (decimal < 0) throw new IllegalArgumentException("Negative numbers not supported");
            StringBuilder hex = new StringBuilder();

            while(decimal != 0){
                int rem = decimal % 16;

                if(decimal % 16 < 10) hex.append(rem);
                else {
                    hex.append((char) ('A' + rem - 10));

                }



                decimal /= 16;
            }
            return hex.reverse().toString();
        }


        public static void main(String[] args) {
            HexDecBinaryConverter converter = new HexDecBinaryConverter();
            String hex = "A1F"; //A1F is 2591 in decimal

            int decimal = converter.HexToDecimal(hex);
            System.out.println("1. Hexadecimal: " + hex + ", Decimal: " + decimal);

            String DecHex = converter.DecToHex(decimal);
            System.out.println("2. Decimal: " + decimal + ", Hexadecimal: " + DecHex);

            String binary = converter.decimalToBinary(decimal);
            System.out.println("3. Decimal: " + decimal + ", Binary: " + binary);

            int binaryInt = converter.BinaryToDecimal(binary);
            System.out.println("4. Binary: " + binary + ", Decimal: " + binaryInt);



        }

    }
