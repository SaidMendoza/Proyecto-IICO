#include <stdio.h>
#include <math.h>


int main()
{
	double l_inicial, l_final, inc; 	//variables que almacenan datos a introducir, l=limite, inc=incremento

	double r_e = 0; //variables que almacenaran los resultados a mostrar, r=resultado, exp=exponente
	double r_exp;

	int i, f, fact;
	scanf_s("%lf %lf %lf", &l_inicial, &l_final, &inc);
	int conteo = (l_final - l_inicial) / inc; //Calcular cu�l va a ser el conteo para la serie de euler
	if (l_inicial == 0 && l_final == 0)
	{
		r_exp = 1;
		r_e = 1;
		printf("%f %f %f", l_inicial, r_e, r_exp);
		return 0;
	}
	else if (inc == 0)
	{
		return 1;
	}while (l_inicial <= l_final + inc)
	{
		
		r_exp = exp(l_inicial);
		printf("%f %f %f\n", l_inicial, r_e, r_exp);
		l_inicial = l_inicial + inc;
		r_e = 0;
	}
}

