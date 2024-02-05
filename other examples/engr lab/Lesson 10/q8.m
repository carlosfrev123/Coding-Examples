EQD = readtable('Earthquake data Idaho.xlsx');
EQDsorted = sortrows(EQD,{'mag'},{'descend'});
mag = EQDsorted.mag; magError = EQDsorted.magError;
MaxMag = (mag+magError);
MinMag =(mag-magError);
mags = table(MaxMag,MinMag);
writetable(mags,'mags.xlsx');

