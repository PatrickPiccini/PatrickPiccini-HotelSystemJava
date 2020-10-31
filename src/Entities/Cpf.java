package Entities;

import java.util.InputMismatchException;

public class Cpf extends HotelSystem{
	
	private String cpf;

    public void cpf (String cpf){
        this.cpf = cpf;
    }

    public boolean valido(){
        if (cpf.equals("00000000000") ||
            cpf.equals("11111111111") ||
            cpf.equals("22222222222") || 
            cpf.equals("33333333333") ||
            cpf.equals("44444444444") || 
            cpf.equals("55555555555") ||
            cpf.equals("66666666666") || 
            cpf.equals("77777777777") ||
            cpf.equals("88888888888") || 
            cpf.equals("99999999999") ||
            (cpf.length() != 11)){
                return false ;
        }
        char num10, num11;
        int soma, i, r, num, peso;

        try{  
            // primeiro digito verificador
            soma = 0;
            peso = 10;
            for(i=0; i<9;i++){
                num = (int)(cpf.charAt(i)- 48);
                soma = soma + (num*peso);
                peso = peso -1;
            }
            r = 11 - (soma % 11);
            if((r == 10)|| (r==11)){
                num10 = '0';
            }else{
                num10 = (char)(r+48);
            }

            // segundo digito verificador
            soma = 0;
            peso = 11;
            for(i=0;i<10;i++){
                num = (int)(cpf.charAt(i)- 48);
                soma = soma + (num*peso);
                peso = peso - 1;
            }
            r= 11 - (soma%11);
            if((r==10)||(r==11)){
                num11 = '0';
            }else{
                num11 = (char)(r+48);
            }
            //valida cpf
            if((num10 == cpf.charAt(9)) && (num11 == cpf.charAt(10))){
                return true;
            }else{
                return false;
            }
        }catch(InputMismatchException erro){
            return false;
        }
    }
}