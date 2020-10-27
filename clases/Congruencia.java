package clases;

public class Congruencia {
        private int m;
        private int a;
        private int c;
        private int semilla;
        private double prev=0;
        public Congruencia(int m, int a, int c, int s){
            this.m = m;
            this.a = a;
            this.c = c;
            this.semilla = s;
        }
        
        public double next(){
            prev = (a * prev + c )%m;
            return  prev/m;
        }     
}
