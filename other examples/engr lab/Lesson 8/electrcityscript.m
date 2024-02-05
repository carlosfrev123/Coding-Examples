Rrv = [ 10e4 2e4 3.5e4 1e5 2e5 ];
vrv = [ 120 80 110 200 350];
R = Rrv';
v = vrv';
i = v./R;
pd = (v.^2)./R;
matrix = [i, pd];

