
tab = readtable('car.xlsx');
tab.Age;
tab.Temp;
tab.Pressure;
tab.Miles;
plotmatrix (table2array (tab));
corrcoef (table2array (tab));

