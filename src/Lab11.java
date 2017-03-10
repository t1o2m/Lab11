import java.util.ArrayList;

public class Lab11
{
    public static void main(String args[])
    {
        //Read in the weights
        //Make sure you change the filename as appropriate!
        //This will only work if "c:\temp\1000 Primes.txt" exists!
        ArrayList<Double> w = CS2004.ReadNumberFile("/Users/x/Documents/1000primes.txt");
        //Set the weights
        ScalesChrome.SetWeights(w);
        //Run 10 repeats
        /*for(int i=0;i<10;++i)
        {
            //Reset the fitness count
            ScalesChrome.ClearFC();
            //The following parameters are not very good!
            //These are the ones you should try and optimise!
            int popsize = 100;
            double mrate = 1/500;
            double crate = 1.0;
            //You will not need to change the following
            SimpleGeneticAlgorithm ga = new SimpleGeneticAlgorithm(popsize,10,1000,mrate,crate);
            //Run the GA for 10,000 function calls
            double f = ga.RunSGA(10000,false).GetFitness();
            System.out.println(f);

        }*/
        int inc=0,dec=0;
        int fit=0;
        int popsize = 100;
        double mrate = 1/500;
        double crate = 1.0;
        while(fit<100){
            ScalesChrome.ClearFC();
            SimpleGeneticAlgorithm ga = new SimpleGeneticAlgorithm(popsize,10,1000,mrate,crate);
            double f = ga.RunSGA(10000,false).GetFitness();
            System.out.println(f);
            if(f>1.0){
                fit=0;

                if(inc<100){
                    inc++;
                    mrate=mrate+(mrate*0.01);
                }
                else{

                    if(dec<100) {
                        dec++;
                        mrate = mrate - (mrate * 0.01);
                    }
                    else if(dec==100&&inc==100){
                     mrate=CS2004.UR(0.001,0.0);
                     inc=0;
                     dec=0;
                    }

                }
            }
            else fit++;
            System.out.println(fit);
        }
        System.out.println(mrate);






    }
}
