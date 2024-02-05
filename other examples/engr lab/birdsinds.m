load('birdsounds.mat');
sound(fullsignal,Fs);
previous = fillmissing(fullsignal,'previous');
linear = fillmissing(fullsignal,'linear');
slpine = fillmissing(fullsignal,'spline');
plotrange=(1005:1045);

A = plot(plotrange,fullsignal(plotrange),'+');
legend(A);