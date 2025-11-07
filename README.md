# Sistema Integrado de Monitoreo y Alerta Temprana (SIAT)

Estructura: carpeta `src` con subcarpetas `vista`, `logica`, `datos`.

Este commit añade un prototipo inicial en Java (esqueleto) organizado según tu petición. La compilación puede necesitar ajustar el classpath porque las fuentes están en `src` (no en `src/main/java`).

Instrucciones rápidas:
- Compilar desde la raíz del repositorio: javac -d out $(find src -name "*.java")
- Ejecutar: java -cp out vista.Main
