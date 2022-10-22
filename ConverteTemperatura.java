import java.util.Scanner;

public class ConverteTemperatura {
    final static double FATOR_C_TO_F_1 = (double)9/5;
    final static int FATOR_C_TO_F_2 = 32;
    final static double FATOR_C_TO_K = 273.15;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Por favor, digite a quantidade de temperaturas que deseja converter:");
        int QuantidadeDeTemperaturas = 0;
        while (QuantidadeDeTemperaturas<1){
                try {
                    QuantidadeDeTemperaturas = sc.nextInt();
                    if (QuantidadeDeTemperaturas<0){
                        System.out.println("A quantidade de temperaturas deve ser um número interio e positivo.");
                        System.out.println("Por favor, digite a quantidade de temepraturas que deseja converter:");
                        sc.nextLine();
                    }
                }catch (Exception e) {
                    System.out.println("A quantidade de temperaturas deve ser um número interio e positivo.");
                    System.out.println("Por favor, digite a quantidade de temepraturas que deseja converter:");
                    sc.nextLine();
                }
        }
        double[] Temperaturas = new double[QuantidadeDeTemperaturas];
        int[] UnidadeTemperatura = new int[QuantidadeDeTemperaturas];
        double[] TemperaturasConvertidas = new double[QuantidadeDeTemperaturas];
        int[] UnidadeTemperaturaConvertidas = new int[QuantidadeDeTemperaturas];
        double T = 0;
        for (int i = 0; i < QuantidadeDeTemperaturas ; i++) {
            Temperaturas[i]= lerTemperatura();
            T =Temperaturas[i];
            UnidadeTemperatura[i]= unidadeTemperaturaEntrada();
            UnidadeTemperaturaConvertidas[i]=unidadeTemperaturaSaida();
            if (UnidadeTemperatura[i] == 1) {
                TemperaturasConvertidas[i]=converteCelcius(T,
                        UnidadeTemperaturaConvertidas[i]);
            } else if (UnidadeTemperatura[i] == 2) {
                TemperaturasConvertidas[i]=converteFahrenheit(T,
                        UnidadeTemperaturaConvertidas[i]);
            } else if (UnidadeTemperatura[i] == 3){
                TemperaturasConvertidas[i]=converteKelvin(T,
                        UnidadeTemperaturaConvertidas[i]);
            }
        }
        int opcao = 0;
        for (int i = 0; i < QuantidadeDeTemperaturas; i++) {
            if ((int) UnidadeTemperatura[i] == 1 && UnidadeTemperaturaConvertidas[i] == 2) {
                System.out.printf("%.2f °C é igual a %.2f °F\n", Temperaturas[i], TemperaturasConvertidas[i]);
            }else if((int) UnidadeTemperatura[i] == 1 && UnidadeTemperaturaConvertidas[i] == 3){
                System.out.printf("%.2f °C é igual a %.2f K\n", Temperaturas[i], TemperaturasConvertidas[i]);
            }else if ((int) UnidadeTemperatura[i] == 2 && UnidadeTemperaturaConvertidas[i] == 1) {
                System.out.printf("%.2f °F é igual a %.2f °C\n", Temperaturas[i], TemperaturasConvertidas[i]);
            }else if((int) UnidadeTemperatura[i] == 2 && UnidadeTemperaturaConvertidas[i] == 3){
                System.out.printf("%.2f °F é igual a %.2f K\n", Temperaturas[i], TemperaturasConvertidas[i]);
            }else if ((int) UnidadeTemperatura[i] == 3 && UnidadeTemperaturaConvertidas[i] == 1){
                System.out.printf("%.2f K é igual a %.2f °C\n", Temperaturas[i], TemperaturasConvertidas[i]);
            }else if((int) UnidadeTemperatura[i] == 3 && UnidadeTemperaturaConvertidas[i] == 2){
                System.out.printf("%.2f K é igual a %.2f °F\n", Temperaturas[i], TemperaturasConvertidas[i]);
            }
        }
        double SomaTemperaturaEntrada = 0;
        double SomaTempraturaSaida=0;
        for (int i = 0; i < QuantidadeDeTemperaturas ; i++) {
            SomaTemperaturaEntrada +=Temperaturas[i];
            SomaTempraturaSaida += TemperaturasConvertidas[i];
        }
        System.out.printf("A media das temperaturas de entrada é: %.2f \n",SomaTemperaturaEntrada/QuantidadeDeTemperaturas);
        System.out.printf("A media das temperaturas convertidas é: %.2f \n",SomaTempraturaSaida/QuantidadeDeTemperaturas);

    }
    public static int unidadeTemperaturaEntrada(){
        System.out.println("Por favor, diga qual é a unidade da temperatura que acabou de digitar");
        System.out.println("Digite:");
        System.out.println("""
                1 - Celsius (°C)
                2 - Fahrenheit (°F)
                3 - Kelvin (K)\s""".indent(4));
        int unidade = 0;
        while (true){
            try{
                unidade = sc.nextInt();
                if (unidade < 0 || unidade > 3){
                    System.out.println("Opção Inválida");
                    System.out.println("Digite:");
                    System.out.println("""
                            1 - Celsius (°C)
                            2 - Fahrenheit (°F)
                            3 - Kelvin (K)\s""".indent(4));
                    sc.nextLine();
                }else {
                    return unidade;
                }
            }catch (Exception e){
                System.out.println("Você precisa digitar um número para prosseguir");
                sc.nextLine();
            }
        }
    }

    public static int unidadeTemperaturaSaida(){
        System.out.println("Por favor, agora diga para qual temepratura você deseja fazer a conversão");
        System.out.println("Digite:");
        System.out.println("""
                1 - Celsius (°C)
                2 - Fahrenheit (°F)
                3 - Kelvin (K)\s""".indent(4));
        int unidade = 0;
        while (true){
            try{
                unidade = sc.nextInt();
                if (unidade < 0 || unidade > 3){
                    System.out.println("Opção Inválida");
                    System.out.println("Digite:");
                    System.out.println("""
                            1 - Celsius (°C)
                            2 - Fahrenheit (°F)
                            3 - Kelvin (K)\s""".indent(4));
                    sc.nextLine();
                }else {
                    return unidade;
                }
            }catch (Exception e){
                System.out.println("Você precisa digitar um número para prosseguir");
                sc.nextLine();
            }
        }
    }
    public static double lerTemperatura(){
        double Temperatura = 0;
        while (true){
            try{
                System.out.println("Digite o valor da temperatura que deseja converter:");
                Temperatura = sc.nextDouble();
                return Temperatura;
            }catch (Exception e){
                System.out.println("Você precisa digitar um número para prosseguir");
                sc.nextLine();
            }
        }
    }

    public static double converteCelcius(double C, int opcao){
        double F, K;
        if (opcao == 1) {
            return C;
        } else if (opcao == 2) {
            F = (double)FATOR_C_TO_F_1*C+FATOR_C_TO_F_2;
            return F;
        } else{
            K = C + FATOR_C_TO_K;
            return K;
        }
    }
    public static double converteFahrenheit(double F, int opcao){
        double C, K;
        if (opcao == 1) {
            C =(F-FATOR_C_TO_F_2)/FATOR_C_TO_F_1;
            return C;
        } else if (opcao == 2) {
            return F;
        } else{
            K = (F + 459.67)/FATOR_C_TO_F_1;
            return K;
        }
    }

    public static double converteKelvin(double K, int opcao){
        double C, F;
        if (opcao == 1) {
            C = K-FATOR_C_TO_K;
            return C;
        } else if (opcao == 2) {
            F= K*FATOR_C_TO_F_1-459.67;
            return F;
        } else{
            return K;
        }
    }
}