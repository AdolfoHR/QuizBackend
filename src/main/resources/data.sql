
-- Insertar preguntas

insert ignore into Question (question_id, question_text, category, question_type) values

(1, '¿De qué manera se puede ejercer el acoso laboral?', 'Acoso laboral', 'Alternativa'),
(2, '¿Cómo se nombra cuando el acoso laboral lo ejerce uno o varios trabajadores de la misma línea jerárquica?', 'Acoso laboral', 'Alternativa'),
(3, '¿De qué forma se llama cuando el acoso lo ejerce un supervisor o una persona superior jerárquicamente en la empresa?', 'Acoso laboral', 'Alternativa'),
(4, '¿Qué hacer en primera instancia de acoso laboral?', 'Acoso laboral', 'Alternativa'),
(5, '¿Cómo puedo denunciar acoso laboral en una segunda instancia?', 'Acoso laboral', 'Alternativa'),
(6, '¿Qué tipo de violencias pueden existir laboralmente?', 'Acoso laboral', 'Alternativa'),
(7, '¿Cuál de las alternativas es un ejemplo de acoso laboral de superiores?', 'Acoso laboral', 'Alternativa'),
(8, '¿Qué es la indemnidad laboral?', 'Acoso laboral', 'Alternativa'),
(9, '¿Qué ley o leyes hablan sobre el acoso laboral en Chile?', 'Acoso laboral', 'Alternativa'),
(10, '¿Qué establece la ley 40 hrs?', 'Ley 40hrs', 'Alternativa'),
(11, '¿Tengo derechos de horario especial si tengo un hijo?', 'Ley 40hrs', 'Alternativa'),
(12, '¿De cuánto debe ser la edad de un hijo/a para poder optar a el derecho especial como cuidador?', 'Ley 40hrs', 'Alternativa'),
(13, '¿A quiénes se aplicará la “Ley 40 horas”?', 'Ley 40hrs', 'Alternativa'),
(14, '¿A qué trabajadores no se aplica la Ley 40 horas?', 'Ley 40hrs', 'Alternativa'),
(15, '¿El sueldo disminuye por menos horas que trabajadas?', 'Ley 40hrs', 'Alternativa');



 --Insertar alternativas

INSERT IGNORE INTO Question_choices (choices_id, question_id, choices_text) VALUES
(1, 1, '["Vertical y diagonal", "Diagonal y horizontal"]'),
(2, 2, '["Vertical", "Diagonal"]'),
(3, 3, '["Horizontal", "Diagonal"]'),
(4, 4, '["Quedarse callado", "Denunciar ante carabineros"]'),
(5, 5, '["No decirle a nadie", "Hablar con tu superior"]'),
(6, 6, '["Violencia fisica", "Violencia financiera"]'),
(7, 7, '["Un compañero se burla de ti por algún defecto personal", "Un superior te llama la atención por un error"]'),
(8, 8, '["Es el derecho que tiene todo empleador al denunciar, el cual inahbilita al trabajador de represalias", "Es el derecho que tiene todo trabajador y empleador al denunciar"]'),
(9, 9, '["Ley de propiedad intelectual (17.336)", "Ley general de educación(20.370)"]'),
(10, 10, '["Establece el descanso laboral a 40 min", "Establece la jornada laboral menor a 40 horas semanales"]'),
(11, 11, '["No tengo derecho a salir de mi lugar de trabajo si tengo un menor de 12 años a mi cuidado, ya que el empleador podría despedirme", "Si es mi derecho tener una banda de dos horas, donde puedo cuidar a un menor hasta los 17"]'),
(12, 12, '["El proyecto no señala límite de edad", "El proyecto señala hasta los 17 años"]'),
(13, 13, '["Se aplica a todos los trabajadores y funcionarios públicos ", "Se aplica sólo a los contratos de honorarios y funcionarios públicos"]'),
(14, 14, '["Ningún trabajador se excluye no importa el área donde trabajes", "Se excluye a los trabajadores dependientes que se rigen por el codigo del trabajador"]'),
(15, 15, '["Si, ya que se implementa un artículo que establece al ser menos horas es equitativo reducir el sueldo del trabajador.", "Si, pero el trabajador podrá optar a ganar horas extras, para mejorar s sueldo."]');



-- Insertar alternativas correctas

INSERT IGNORE INTO Correct_choices (correct_choices_id, question_id, correct_choices_text) VALUES
(1, 1, 'Horizontal y vertical'),
(2, 2, 'Horizontal'),
(3, 3, 'Vertical'),
(4, 4, 'Solicitar el reglamento interno de la empresa y denunciar en recursos humanos'),
(5, 5, 'Ingresando una denuncia en la Dirección del trabajo'),
(6, 6, 'Violencia verbal'),
(7, 7, 'Un superior jerárquico te aísla socialmente y cuestiona tus acciones'),
(8, 8, 'Es el derecho que tiene todo trabajador al denunciar, el cual habilita al empleador de represalias'),
(9, 9, 'Ley 20.607 y Ley Karin 21.643'),
(10, 10, 'Establece la jornada laboral igual a 40 horas semanales'),
(11, 11, 'Si es mi derecho tener una banda de dos horas, donde puedo cuidar a un menor de 12 años'),
(12, 12, 'El proyecto señala menores de 12 años'),
(13, 13, 'Solo aplica a los trabajadores dependientes que se rigen por el código del trabajo'),
(14, 14, 'Se excluyen los funcionarios públicos y con contrato de honorarios'),
(15, 15, 'No, ya que implementa un artículo en el que se prohíbe la disminución de sueldos');

