load("velocity.mat");
hold on
plot(r,u,'x','Color','k');
p = polyfit(r,u,2);
rp = -0.1:0.1:0.1;
up = polyval(p,rp);
plot(rp,up);
hold off


