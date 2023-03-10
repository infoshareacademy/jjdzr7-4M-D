INSERT INTO recipes (id, name, preparation_method, estimated_cooking_time, calories, difficulty, dish_type)
VALUES (1, 'Scrambled Eggs',
        '1. Beat the eggs in a bowl. 2. Heat butter in a frying pan. 3. Pour eggs in the frying pan. 4. Scramble eggs with a spatula until cooked.',
        5, 200, 0, 2);

INSERT INTO ingredients (id, name, quantity, unit, price, ingredients_list_id)
VALUES (1, 'Eggs', 2, 0, 2.50, 1);
INSERT INTO ingredients (id, name, quantity, unit, price, ingredients_list_id)
VALUES (2, 'Butter', 20, 0, 1.50, 1);

INSERT INTO recipes (id, name, preparation_method, estimated_cooking_time, calories, difficulty, dish_type)
VALUES (2, 'Greek Salad',
        '1. Chop the tomatoes, cucumbers, and onions. 2. Cut the feta cheese into small cubes. 3. Combine the vegetables and cheese in a bowl. 4. Mix olive oil, lemon juice, salt, and pepper in a separate bowl. 5. Pour the dressing over the salad.',
        15, 150, 1, 2);

INSERT INTO ingredients (id, name, quantity, unit, price, ingredients_list_id)
VALUES (3, 'Tomatoes', 4, 0, 4.50, 2);
INSERT INTO ingredients (id, name, quantity, unit, price, ingredients_list_id)
VALUES (4, 'Cucumbers', 2, 0, 2.50, 2);
INSERT INTO ingredients (id, name, quantity, unit, price, ingredients_list_id)
VALUES (5, 'Onion', 1, 0, 1.00, 2);
INSERT INTO ingredients (id, name, quantity, unit, price, ingredients_list_id)
VALUES (6, 'Feta Cheese', 150, 0, 7.50, 2);
INSERT INTO ingredients (id, name, quantity, unit, price, ingredients_list_id)
VALUES (7, 'Olive Oil', 50, 1, 4.00, 2);
INSERT INTO ingredients (id, name, quantity, unit, price, ingredients_list_id)
VALUES (8, 'Lemon Juice', 1, 1, 2.00, 2);
INSERT INTO ingredients (id, name, quantity, unit, price, ingredients_list_id)
VALUES (9, 'Salt', 1, 0, 0.50, 2);
INSERT INTO ingredients (id, name, quantity, unit, price, ingredients_list_id)
VALUES (10, 'Pepper', 1, 0, 0.50, 2);

INSERT INTO recipes (id, name, preparation_method, estimated_cooking_time, calories, difficulty, dish_type)
VALUES (3, 'Homemade Pizza',
        '1. Preheat the oven to 230°C. \n2. Mix flour, yeast, salt and sugar in a bowl. \n3. Add oil and water, then stir until you have a sticky dough. \n4. Flour a work surface and knead the dough for 10 minutes. \n5. Let the dough rest in a warm place for 30 minutes. \n6. Spread the dough on a baking sheet and add toppings of your choice. \n7. Bake the pizza for 10-15 minutes or until the crust is golden brown.',
        30, 800, 1, 2);

INSERT INTO ingredients (id, ingredients_list_id, name, quantity, unit, price)
VALUES (11, 3, 'Flour', 500, 0, 2.50),
       (12, 3, 'Yeast', 7, 0, 2.00),
       (13, 3, 'Salt', 1, 0, 0.50),
       (14, 3, 'Sugar', 1, 0, 1.00),
       (15, 3, 'Olive Oil', 50, 1, 5.00),
       (16, 3, 'Water', 300, 1, 0.00),
       (17, 3, 'Tomato Sauce', 200, 1, 2.00),
       (18, 3, 'Mozzarella Cheese', 200, 0, 5.00),
       (19, 3, 'Pepperoni', 100, 0, 6.00);

INSERT INTO recipes (id, name, preparation_method, estimated_cooking_time, calories, difficulty, dish_type)
VALUES (4, 'Omelette',
        '1. Beat eggs, milk, salt and pepper together in a bowl. \n2. Heat butter in a non-stick skillet over medium-high heat. \n3. Add onions and cook until they are translucent. \n4. Add the egg mixture and let it cook for 2-3 minutes or until the edges start to set. \n5. Use a spatula to gently lift the edges of the omelette and let the uncooked egg run underneath. \n6. Add cheese, ham and mushrooms on one half of the omelette. \n7. Use the spatula to fold the other half of the omelette over the filling. \n8. Let the omelette cook for another minute or until the cheese is melted.',
        10, 400, 0, 3);

INSERT INTO ingredients (id, ingredients_list_id, name, quantity, unit, price)
VALUES (20, 4, 'Eggs', 2, 0, 2.00),
       (21, 4, 'Milk', 30, 1, 1.00),
       (22, 4, 'Salt', 1, 0, 0.50),
       (23, 4, 'Pepper', 1, 0, 1.00),
       (24, 4, 'Butter', 10, 0, 2.50),
       (25, 4, 'Onion', 50, 0, 1.50);

INSERT INTO recipes (id, name, preparation_method, estimated_cooking_time, calories, difficulty, dish_type)
VALUES (5, 'Shrimp Scampi',
        '1. Cook pasta according to package directions. 2. In a large skillet, heat olive oil over medium heat. Add garlic and red pepper flakes and cook until fragrant. 3. Add shrimp and cook until pink, about 2-3 minutes per side. 4. Add lemon juice and white wine to skillet and simmer for 2-3 minutes. 5. Serve shrimp and sauce over pasta, garnished with parsley.',
        25, 400, 2, 1);

INSERT INTO ingredients (id, ingredients_list_id, name, quantity, unit, price)
VALUES (26, 5, 'Pasta', 8, 1, 2.5),
       (27, 5, 'Olive Oil', 2, 0, 6),
       (28, 5, 'Garlic', 3, 0, 2),
       (29, 5, 'Red Pepper Flakes', 1, 0, 1.5),
       (30, 5, 'Shrimp', 1.5, 0, 12),
       (31, 5, 'Lemon Juice', 1, 1, 1.5),
       (32, 5, 'White Wine', 0.5, 1, 8),
       (33, 5, 'Parsley', 0.25, 0, 1);

INSERT INTO recipes (id, name, preparation_method, estimated_cooking_time, calories, difficulty, dish_type)
VALUES (6, 'Chicken Parmesan',
        '1. Preheat oven to 375°F (190°C). 2. Season chicken with salt and pepper. Dredge in flour, then dip in egg, and coat with breadcrumbs. 3. In a large skillet, heat olive oil over medium heat. Add chicken and cook until browned on both sides, about 3-4 minutes per side. 4. Place chicken in a baking dish and top with tomato sauce and mozzarella cheese. 5. Bake for 20-25 minutes, until cheese is melted and bubbly. 6. Serve chicken over spaghetti with additional tomato sauce.',
        45, 550, 2, 1);

INSERT INTO ingredients (id, ingredients_list_id, name, quantity, unit, price)
VALUES (34, 6, 'Chicken Breasts', 2, 0, 8),
       (35, 6, 'Salt', 1, 0, 1),
       (36, 6, 'Black Pepper', 0.5, 0, 1),
       (37, 6, 'Flour', 0.5, 1, 1),
       (38, 6, 'Egg', 1, 0, 0.5),
       (39, 6, 'Breadcrumbs', 0.5, 1, 1.5),
       (40, 6, 'Olive Oil', 2, 0, 6),
       (41, 6, 'Tomato Sauce', 1, 1, 2),
       (42, 6, 'Mozzarella Cheese', 0.5, 1, 2.5),
       (43, 6, 'Spaghetti', 8, 1, 2.5);

INSERT INTO recipes (id, name, preparation_method, estimated_cooking_time, calories, difficulty, dish_type)
VALUES (7, 'Tiramisu',
        '1. In a large mixing bowl, beat egg yolks and sugar until light and fluffy. 2. Add mascarpone cheese and beat until smooth. 3. In a separate bowl, beat egg whites until stiff peaks form. 4. Gently fold the egg whites into the mascarpone mixture. 5. Dip ladyfingers in coffee and layer in the bottom of a serving dish. 6. Spread a layer of the mascarpone mixture over the ladyfingers. Repeat layers. 7. Cover and refrigerate for at least 2 hours, or overnight. 8. Dust with cocoa powder before serving.',
        30, 400, 2, 3);

INSERT INTO ingredients (id, ingredients_list_id, name, quantity, unit, price)
VALUES (44, 7, 'Egg Yolks', 4, 0, 1.5),
       (45, 7, 'Sugar', 1, 1, 1),
       (46, 7, 'Mascarpone Cheese', 16, 1, 6),
       (47, 7, 'Egg Whites', 4, 0, 1),
       (48, 7, 'Ladyfingers', 24, 0, 3),
       (49, 7, 'Brewed Coffee', 2, 1, 1.5),
       (50, 7, 'Cocoa Powder', 1, 0, 1.5);

INSERT INTO recipes (id, name, preparation_method, estimated_cooking_time, calories, difficulty, dish_type)
VALUES (8, 'Tomato Soup',
        '1. In a large pot, sauté chopped onions in olive oil until translucent. 2. Add garlic and sauté for another minute. 3. Add chopped tomatoes, tomato paste, vegetable or chicken broth, and herbs (such as basil and oregano). 4. Bring to a boil, then reduce heat and let simmer for 20-30 minutes. 5. Use an immersion blender or transfer the soup to a blender to purée until smooth. 6. Stir in cream or milk, if desired. 7. Season with salt and pepper to taste. 8. Garnish with fresh basil and serve hot.',
        40, 200, 1, 0);

INSERT INTO ingredients (id, ingredients_list_id, name, quantity, unit, price)
VALUES (51, 8, 'Onions', 2, 0, 1.5),
       (52, 8, 'Olive Oil', 2, 0, 6),
       (53, 8, 'Garlic', 3, 0, 1),
       (54, 8, 'Tomatoes', 4, 0, 3),
       (55, 8, 'Tomato Paste', 2, 1, 1),
       (56, 8, 'Vegetable or Chicken Broth', 4, 1, 2),
       (57, 8, 'Basil', 1, 0, 1.5),
       (58, 8, 'Oregano', 0.5, 0, 1),
       (59, 8, 'Cream or Milk', 1, 1, 2),
       (60, 8, 'Salt', 1, 0, 1),
       (61, 8, 'Black Pepper', 0.5, 0, 1),
       (62, 8, 'Fresh Basil', 1, 0, 1);

INSERT INTO recipes (id, name, preparation_method, estimated_cooking_time, calories, difficulty, dish_type)
VALUES (9, 'Caprese Salad',
        '1. Slice the tomatoes and mozzarella cheese into even rounds. 2. Arrange the tomato and mozzarella slices in a circular pattern on a plate, alternating between the two. 3. Scatter fresh basil leaves over the top. 4. Drizzle with extra-virgin olive oil and balsamic vinegar. 5. Season with salt and pepper to taste. 6. Serve immediately.',
        10, 200, 1, 2);

INSERT INTO ingredients (id, ingredients_list_id, name, quantity, unit, price)
VALUES (63, 9, 'Tomatoes', 3, 0, 3),
       (64, 9, 'Fresh Mozzarella Cheese', 8, 1, 6),
       (65, 9, 'Fresh Basil Leaves', 10, 0, 1.5),
       (66, 9, 'Extra-Virgin Olive Oil', 2, 0, 4),
       (67, 9, 'Balsamic Vinegar', 1, 1, 2),
       (68, 9, 'Salt', 1, 0, 1),
       (69, 9, 'Black Pepper', 1, 0, 1);

INSERT INTO recipes (id, name, preparation_method, estimated_cooking_time, calories, difficulty, dish_type)
VALUES (10, 'Pumpkin cream',
        '1. Cut a medium-sized pumpkin into small cubes and roast in the oven for 30 minutes until soft. 2. In a large pot, sauté finely chopped onion and garlic until translucent. 3. Add the roasted pumpkin, vegetable stock, and a pinch of nutmeg. 4. Bring to a boil and let simmer for 10-15 minutes. 5. Blend the soup in a food processor or with an immersion blender until smooth. 6. Add cream to the soup and heat until warmed through. 7. Serve hot with crusty bread and fresh parsley on top.',
        45, 250, 2, 0);

INSERT INTO ingredients (id, ingredients_list_id, name, quantity, unit, price)
VALUES (70, 10, 'Pumpkin', 1, 1, 3),
       (71, 10, 'Onion', 1, 0, 1),
       (72, 10, 'Garlic', 2, 0, 1.5),
       (73, 10, 'Vegetable Stock', 4, 1, 3),
       (74, 10, 'Nutmeg', 1, 0, 1),
       (75, 10, 'Cream', 1, 1, 2),
       (76, 10, 'Salt', 1, 0, 1),
       (77, 10, 'Pepper', 1, 0, 1),
       (78, 10, 'Parsley', 1, 0, 1.5);

UPDATE ingredients_seq SET next_val = 79;
UPDATE recipe_seq SET next_val = 11;