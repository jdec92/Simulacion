# Simulación Estadistico, Distribución Binomial
Programa donde se realiza una simulación estadistica de una distribución Binomial

## Guía de Usuario
Al ejecutar el proyecto nos aparecera la siguiente pantalla

![Pantalla principal del proyecto](https://raw.githubusercontent.com/jdec92/assets/master/statiscus_simulation/main.png)

Introduciremos el tamaño de la distribución Binomial que deseemos (debe ser un número entero, si no, nos saldrá un mensaje informando que debe ser entero)
También introduciremos la probabilidad correspondiente a la distribución binomial (debe ser 0<=p<=1)
A continuación pulsaremos Calcular, y nos aparece la siguiente pantalla

![Menu Distribución Binomial](https://raw.githubusercontent.com/jdec92/assets/master/statiscus_simulation/screen_calculate.png)

Donde podremos realizar las siguientes operaciones:

 * Consultar la media y varianza, que se actualizara, si modificamos los datos de la Binomial

![Media y Varianza](https://raw.githubusercontent.com/jdec92/assets/master/statiscus_simulation/mean_variance.png)

 * Modificar si queremos la distribución Binomial, y/o el tamaño de la muestra X

![Distribución con datos por argumento](https://raw.githubusercontent.com/jdec92/assets/master/statiscus_simulation/distribution_value.png)

Podemos modificar el tamaño de la distribución y el tamaño de la muestra.
Si modificamos N o el tamaño de la Muestra X, e introducimos un número no entero nos mostrara un mensaje de error como este.

![Valores Erroneos](https://raw.githubusercontent.com/jdec92/assets/master/statiscus_simulation/check_values.png)

Igual pasara si introducimos un número no decimal en la probabilidad.
Si introducimos una probabilidad que no esté entre el intervalo [0,1], nos lo indicara que no esta dentro de este intervalo.

_NOTA:Siempre que modifiquemos los campos de la distribución Binomial (N o p), pulsar intro después de escribir el número que deseemos, y se nos recalculara la media y la varianza._

 * Crear el Grafico para nuestro frecuencia de la distribución Binomial, Al pulsar en Crear Grafico sin intervalo nos aperecera el grafico correspondiente como se observa:

![Histograma Binomial con intervalo definido](https://raw.githubusercontent.com/jdec92/assets/master/statiscus_simulation/binomial_histogram.png)

 * Crear un Grafo con intervalos de la distribución Binomial

![Media y Varianza](https://raw.githubusercontent.com/jdec92/assets/master/statiscus_simulation/create_histogram_by_frequency.png)

Tendremos que indicar de cuanta amplitud queremos para nuestro intervalo, y a continuación pulsaremos en Crear Grafica.
La amplitud del intervalo debe ser un número entero, en otro caso nos mostrara un mensaje de error indicando que no es un entero la amplitud.
Al pulsar sobre Crear Grafica, nos creara la Grafica correspondiente y la tabla de comparaciones de valores que ahora veremos.

![Tabla de Estimación para la distribución](https://raw.githubusercontent.com/jdec92/assets/master/statiscus_simulation/estimation_table.png)

En la tabla que hemos creado nos aparece el intervalo, el valor estimado con nuestra distribución, el valor Real y el Error.
El valor estimado calculado por número de veces que cumple Bernoulli divido el número total de la muestra.
El valor real calculado con la fórmula de la Distribución Binomial.
Y el error cometido al comparar el valor estimado menos el valor Real.

 * Crear Grafico de la distribución de la muestra o teorema central de limites
Al pinchar en Crear Grafica nos creara un Histograma del teorema Central de Limites.

![Histograma del Teorema Central de Limites](https://raw.githubusercontent.com/jdec92/assets/master/statiscus_simulation/sample_frequency.png)

_NOTA: Todos los métodos, antes de crear las Gráficas comprueba que los campos insertados como tamaño N y p, y el tamaño de la muestra son válidos_

