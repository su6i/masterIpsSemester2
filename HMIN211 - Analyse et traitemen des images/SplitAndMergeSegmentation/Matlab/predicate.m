function flag = predicate(region)
global sdThr
sd = std2(region);
m = mean2(region);
flag = (sd > sdThr) & (m > 50) & (m < 200);
% flag = (sd > sqrt(10));
% if length(region) >= 512/4
%     flag = (sd > sdThr) & (m > 0);
% else
%     flag = (sd > sdThr) & (m > 100);
% end