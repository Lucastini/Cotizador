
package negocio;

public class Calculadora {
    private float argumento;
    private int operacion;
    
    public Calculadora(){
        argumento=0f;
        operacion=-1;
    }

    public float getArgumento() {
        return argumento;
    }

    public void setArgumento(float argumento) {
        this.argumento = argumento;
    }

    public int getOperacion() {
        return operacion;
    }

    public void setOperacion(int operacion) {
        this.operacion = operacion;
    }
    
    public float igual(float arg2){
        float res=0f;
        switch(operacion){
            case 1:
                res=argumento+arg2;
                break;
            case 2:
                res=argumento-arg2;
                break;
            case 3:
                res=argumento*arg2;
                break;
            case 4:
                res=argumento/arg2;
                break;
            default:
                res=0;
        }
        argumento=0;
        operacion=-1;
        return res;
    }
                
        
    
}
