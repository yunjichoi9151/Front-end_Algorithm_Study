SELECT ANIMAL_ID, NAME, INTAKE_CONDITION
FROM ANIMAL_INS
WHERE INTAKE_CONDITION != 'Aged'
ORDER BY ANIMAL_ID