#include <stdio.h>
#include <math.h>


int main()
{
	double l_inicial, l_final, inc; 	

	double r_e = 0; 
	double r_exp;

	int i, f, fact;
	scanf_s("%lf %lf %lf", &l_inicial, &l_final, &inc);
	int conteo = (l_final - l_inicial) / inc; 
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
		for (i = 0; i <= conteo; i++)
		{
			fact = 1;
			for (f = 1; f <= i; f++)
			{
				fact = fact * f;
			}
			r_e = r_e + (pow(l_inicial, i)) / fact;
		}
		r_exp = exp(l_inicial);
		printf("%f %f %f\n", l_inicial, r_e, r_exp);
		l_inicial = l_inicial + inc;
		r_e = 0;
	}
}

