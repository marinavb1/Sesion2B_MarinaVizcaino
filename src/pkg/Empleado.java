package pkg;

public class Empleado {
	public enum TipoEmpleado{Vendedor, Encargado};
	
	public static float CalculaNominaBruta(TipoEmpleado tipo, float ventasMes, float HorasExtra) {
		
		float SalarioBase=0, primas=0, extras=0;
		
		//determinacion salario base
		if(tipo==TipoEmpleado.Encargado) {
			SalarioBase=2500;
		}else if(tipo==TipoEmpleado.Vendedor) {
			SalarioBase=2000;
		}
		
		//determinacion prima
		
		if(ventasMes>=1500) {
			primas=200;
		}else if(ventasMes>=1000) {
			primas=100;
		}else if(ventasMes<0) {
			primas=-1;
		}
		
		
		
		
		//calculo horas extras
		
		if(HorasExtra<0) {
			extras=-1;
		}else {
			extras=30*HorasExtra;
		}

		
		//Si los parametros introducidos son erroneos devolver -1	
		if(primas==-1 || extras==-1) {
			return -1;
		}else {
			float salario=SalarioBase+primas+extras;
			return salario;
		}
		
		
	}
	
	
	public static float calculoNominaNeta(float nominaBruta) {
		float nominaNeta=2;
		if(nominaBruta<2100) {
			nominaNeta=nominaBruta;
		}else if(nominaBruta>2100 && nominaBruta<2500){
			nominaNeta=nominaBruta-nominaBruta*0.15f;
		}else if(nominaBruta>2500) {
			nominaNeta=nominaBruta-nominaBruta*0.18f;
		}
		return nominaNeta;
	}
	
	
}
