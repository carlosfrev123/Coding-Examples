A = readmatrix('scores.xlsx');
studentiDs = A(1,1:end);
minScore = min(A);
sumMinusMinScore = sum(A) - min(A) - studentiDs;
testAvg = sumMinusMinScore./5;
iDs = studentiDs';
avg = testAvg';
matrixIDandAvg = [ iDs avg ];
writematrix(matrixIDandAvg,'matrixIDandAvg.xlsx');   