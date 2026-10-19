# Comprensión del diseño — Enunciado B
**Nombre:** Melany Morales 
**Fecha:** 19/10/2026

Responde con tus palabras, basándote en `docs/UML-final.md`. Respuestas
concisas (2–4 líneas por pregunta). Evidencia que entendiste el contrato
**antes** de programar.

---

### 1. Herencia y polimorfismo
¿Por qué `Modelo` es una clase abstracta y no concreta? Menciona qué método
obliga a cada subclase a implementar y qué gana el sistema con eso.

> _Tu respuesta:_
Modelo es abstracta porque funciona como una plantilla base que agrupa los atributos y métodos comunes, pero no tiene sentido crear un modelo genérico sin saber qué tipo es. Obliga a que cada subclase implemente por su cuenta el método entrenar(). Con esto ganamos polimorfismo, lo que nos permite tratar a cualquier modelo de forma uniforme sin preocuparnos por los detalles internos de cada uno.---

### 2. Composición vs. agregación
Explica la diferencia entre `Experimento ◆— Modelo` (composición) y
`Plataforma ◇— Experimento` (agregación). ¿Qué pasaría con el modelo si se
elimina el experimento? ¿Y con los experimentos si se elimina la plataforma?

> _Tu respuesta:_
La composición significa que el modelo pertenece por completo al experimento; si el experimento se borra, el modelo muere con él porque su ciclo de vida depende totalmente de este. En cambio, la agregación es una relación más floja, ya que los experimentos se crean por fuera y solo se registran en la plataforma, por lo que si la plataforma se elimina, los experimentos siguen existiendo por su cuenta.
---

### 3. Asociación
En `Investigador — Experimento`, ¿quién es dueño de quién? ¿Por qué se modela
como N:M y no como composición?

> _Tu respuesta:_
Ninguno es dueño del otro, porque son totalmente independientes y solo se conocen mediante referencias. Se modela como N:M porque un investigador puede participar en varios experimentos y, al mismo tiempo, un experimento puede tener a varios investigadores trabajando en él. No es composición porque si el investigador se va o se elimina, los experimentos no tienen por qué borrarse.
---

### 4. Dependencia
¿Por qué `Modelo` **depende** de `MetricaEvaluacion` en lugar de **tenerlo**
como atributo? ¿Qué ventaja tiene pasar el servicio como parámetro?

> _Tu respuesta:_
Depende de él porque el modelo no necesita guardar una métrica de forma permanente en su estado interno, sino que solo la usa puntualmente en un momento dado para calcular un resultado. La ventaja de pasarlo como parámetro es que desacoplamos el código, el modelo no se casa con una sola forma de evaluar, sino que le podemos inyectar cualquier métrica que necesitemos en el momento de la ejecución.---

### 5. Listas
En este proyecto se usan dos estructuras distintas:
- `int[] lossPorEpoca` en `Modelo`
- `ArrayList<Experimento>` en `Plataforma`

Explica por qué en cada caso se eligió esa estructura y no la otra.

> _Tu respuesta:_
> Se usó un arreglo primitivo fijo (int[]) en Modelo porque el número máximo de épocas suele conocerse de antemano o tiene un tamaño delimitado, lo que ahorra memoria y es más eficiente para registrar números puros. Por el contrario, se usó un ArrayList<Experimento> en Plataforma porque la cantidad de experimentos que se van creando es dinámica, y necesitamos una estructura flexible que permita agregar, quitar o consultar elementos sobre la marcha sin preocuparnos por un límite fijo de tamaño.