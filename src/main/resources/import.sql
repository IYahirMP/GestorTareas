-- Eliminar datos existentes (opcional, útil para reinicios limpios durante el desarrollo)
DELETE FROM tareas;

-- Insertar tareas de ejemplo
INSERT INTO tareas (titulo, descripcion, creada, completada, fecha_vencimiento) VALUES ('Preparar presentación Spring Boot', 'Crear diapositivas y ejemplos de código para la demo del gestor de tareas.', '2025-05-28 10:00:00', FALSE, '2025-06-05 17:00:00');
INSERT INTO tareas (titulo, descripcion, creada, completada, fecha_vencimiento) VALUES ('Investigar Lombok', 'Leer documentación y ejemplos sobre Project Lombok para reducir código boilerplate.', '2025-05-29 09:30:00', 0, '2025-06-03 12:00:00');
INSERT INTO tareas (titulo, descripcion, creada, completada, fecha_vencimiento) VALUES ('Comprar víveres', 'Leche, pan, huevos, frutas y verduras frescas.', '2025-05-29 18:00:00', 1, '2025-05-29 20:00:00');
INSERT INTO tareas (titulo, descripcion, creada, completada, fecha_vencimiento) VALUES ('Llamar a Juan', 'Recordarle sobre la reunión del lunes por la mañana.', '2025-05-30 08:45:00', 0, NULL);
INSERT INTO tareas (titulo, descripcion, creada, completada, fecha_vencimiento) VALUES ('Planificar fin de semana', 'Buscar actividades y restaurantes para el sábado y domingo.', '2025-05-30 09:15:00', 0, '2025-05-31 10:00:00');