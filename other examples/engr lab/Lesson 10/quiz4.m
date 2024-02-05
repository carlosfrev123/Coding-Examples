load('Quakes.mat')
AllQuakes = [SmallQuakes; LargeQuakes];
T2 = datetime(2017,9,7);
T1 = datetime(2017,9,1);

SeptQuakes = AllQuakes(1:146,:);
geobubble(SeptQuakes.latitude,SeptQuakes.longitude,SeptQuakes.mag);
title('Earthquakes taken place during September 2017');
