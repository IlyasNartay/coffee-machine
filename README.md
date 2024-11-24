
1. Создайте базу данных PostgreSQL:
   ```sql
   CREATE DATABASE coffeemachine;
   ```
2. Убедитесь, что у вас есть пользователь и пароль PostgreSQL. Например:
   - Пользователь: `postgres`
   - Пароль: `yourpassword`

3. Измените настройки подключения в `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/coffeemachine
   spring.datasource.username=postgres
   spring.datasource.password=yourpassword
   ```

### 3. Сборка проекта
Соберите проект с помощью Maven:
```bash
mvn clean install
```

### 4. Запуск приложения
Запустите приложение с помощью Maven:
```bash
mvn spring-boot:run
```

Или с помощью JAR-файла:
```bash
java -jar target/coffee-machine-api-1.0.0.jar
```

### 5. Доступ к Swagger UI
После успешного запуска приложения откройте Swagger UI в браузере:
```
http://localhost:8080/swagger-ui.html
```

---

## Эндпоинты API

### **Coffee**
- `GET /api/coffees` — Получить список всех напитков.
- `GET /api/coffees/most-popular` — Получить самый популярный напиток.
- `POST /api/coffees` — Добавить новый напиток.

### **Ingredient**
- `GET /api/ingredients` — Получить список всех ингредиентов.
- `POST /api/ingredients` — Добавить или обновить ингредиент.

### **Recipe**
- `GET /api/recipes/coffee/{coffeeId}` — Получить рецепт для напитка.
- `POST /api/recipes` — Добавить новый рецепт.

### **Statistics**
- `GET /api/statistics/coffee/{coffeeId}/date/{date}` — Получить статистику для напитка.
- `POST /api/statistics` — Сохранить статистику.

### **HolidayCache**
- `GET /api/holidays/date/{date}/country/{countryCode}` — Проверить праздничный день.
- `POST /api/holidays` — Сохранить информацию о праздничном дне.

---

## Тестирование
Для тестирования API используйте Swagger UI или инструмент Postman.

---

## Используемые технологии
- **Java 22**
- **Spring Boot 3.4**
- **PostgreSQL**
- **Swagger (Springdoc OpenAPI)**
- **Maven**

---
