-- Таблица для напитков
CREATE TABLE coffee (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(50) NOT NULL,            -- Название напитка (например, эспрессо)
                        water INT NOT NULL,                   -- Количество воды (в мл)
                        milk INT DEFAULT 0,                   -- Количество молока (в мл)
                        coffee_beans INT NOT NULL,            -- Количество кофе (в граммах)
                        popularity INT DEFAULT 0              -- Популярность напитка
);

-- Таблица для ингредиентов
CREATE TABLE ingredient (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(50) NOT NULL,            -- Название ингредиента (например, вода, кофе)
                            quantity INT NOT NULL                 -- Количество ингредиента (в граммах или мл)
);

-- Таблица для рецептов
CREATE TABLE recipe (
                        id SERIAL PRIMARY KEY,
                        coffee_id INT NOT NULL,               -- Ссылка на напиток
                        ingredient_id INT NOT NULL,           -- Ссылка на ингредиент
                        quantity INT NOT NULL,                -- Количество ингредиента для рецепта
                        FOREIGN KEY (coffee_id) REFERENCES coffee(id),
                        FOREIGN KEY (ingredient_id) REFERENCES ingredient(id)
);

-- Таблица для статистики
CREATE TABLE statistics (
                            id SERIAL PRIMARY KEY,
                            coffee_id INT NOT NULL,               -- Напиток, для которого ведется статистика
                            date DATE NOT NULL DEFAULT CURRENT_DATE, -- Дата заказа
                            count INT DEFAULT 1,                  -- Количество заказов за день
                            FOREIGN KEY (coffee_id) REFERENCES coffee(id)
);

-- Таблица для кеширования праздничных дней
CREATE TABLE holidays_cache (
                                id SERIAL PRIMARY KEY,
                                date DATE NOT NULL,                   -- Дата праздника
                                country_code VARCHAR(10) NOT NULL,    -- Код страны (например, KZ, US)
                                description VARCHAR(100)              -- Описание праздника
);

-- Заполнить таблицу ингредиентов базовыми данными
INSERT INTO ingredient (name, quantity)
VALUES
    ('Вода', 10000),    -- 10 литров воды
    ('Кофе', 2000),     -- 2 кг кофе
    ('Молоко', 5000);   -- 5 литров молока

-- Добавить стандартные напитки (пример)
INSERT INTO coffee (name, water, milk, coffee_beans)
VALUES
    ('Эспрессо', 50, 0, 10),
    ('Американо', 100, 0, 10),
    ('Капучино', 50, 50, 10);

-- Пример заполнения рецептов для напитков
INSERT INTO recipe (coffee_id, ingredient_id, quantity)
VALUES
-- Рецепт для эспрессо
(1, 1, 50), -- Вода
(1, 2, 10), -- Кофе
-- Рецепт для американо
(2, 1, 100), -- Вода
(2, 2, 10), -- Кофе
-- Рецепт для капучино
(3, 1, 50), -- Вода
(3, 2, 10), -- Кофе
(3, 3, 50); -- Молоко
