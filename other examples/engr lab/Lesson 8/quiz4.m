A = [ 3 1 1 2 1; 1 2 1 3 1; 1 1 0 3 3; 2 0 3 1 2; 1 2 3 0 2 ];
sum12 = sum(A(1:2,1:end));
sum12x100 = 100*sum12;
sum345 = sum(A(3:5,1:end));
sum345x200 = 200*sum345;
tot = sum12x100 + sum345x200;

