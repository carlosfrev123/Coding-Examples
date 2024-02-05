BOS=[2.67 1 1.21 3.09 3.43 4.71 3.88 3.08 4.10 2.62 1.01 5.93];
SEA=[6.83 3.63 7.2 2.68 2.05 2.96 1.04 0 0.03 6.71 8.28 6.85];

%a
YearTotBos = sum(BOS);
MonthAvgBos = YearTotBos/12;

YearTotSea = sum(SEA);
MonthAvgSea = YearTotSea/12;

%b
v=BOS>MonthAvgBos*ones(size(BOS));
sum(v)

v=SEA>MonthAvgSea*ones(size(SEA));
sum(v)
%c

v=find(BOS<SEA);