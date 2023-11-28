package csvUtils;

public interface CSVFormat {
    String csvFormat();
    String csvHeader();
}

/*
STUDENT

NAME,ID,PASSWORD,PROGRAMME, GRADE NAME, Module NAME - then look for it in programme
programme ,
(set this to null, if its not null then look for it with uni.getProramme etc - so programmes parsed before students,

teacher
name,id,password,departmentname

department
name, programmes name--


programmes
name,duration,ProgrammType,MODULES -- name,cutoff,year,Semester


grades . csv + id
modules . csv + programme name

department . csv -> remove programme names
students.csv -> remove grades
programems . csv -> remove modules
 */