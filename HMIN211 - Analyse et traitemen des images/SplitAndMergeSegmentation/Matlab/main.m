I_raw = imread('E:\Amir\SplitMerge\lena.pgm');
% I_raw = imread('E:\Amir\Morphological\Colourful\lena.ppm');
% I_raw = imread('liftingbody.png');
%%
figure, 
subplot(221),
imshow(I_raw), title('Original')
%
global sdThr
sdThr = 10;
mindim = 2 ^ 1;

if length(size(I_raw)) == 3
    I = rgb2gray(I_raw);
else
    I = I_raw;
end % if length(size(I)) == 3

[g, S] = splitmerge(I, mindim, @predicate);
 subplot(222)
imshow(S, [])
title('quadtree')

segNb = length(unique(g)) - 1;
% figure,
% imshow(g, [])
% title(['# of segments: ',num2str(segNb),''])
cmap = jet(segNb);
g_color = zeros(size(I, 1), size(I, 2), 3);
for i = 1 : size(g_color, 1)
    for j = 1 : size(g_color, 2)
        if g(i, j) ~= 0
       g_color(i, j, :) = cmap(g(i, j), :);
        end
    end
end
subplot(223),
imagesc(g_color)
colormap(cmap)
axis image
title(['segmentsNb: ',num2str(segNb),', minDim: ',num2str(mindim),', stdThr: ',num2str(sdThr),''])

g_real = uint8(nan(size(I_raw)));
for i = 1 : length(unique(g))
    for j = 1 : size(I_raw, 3)
    ch1 = I_raw(:, :, j);
    g_realCh1 = g_real(:, :, j);
     g_realCh1(g == i-1) = mean(ch1(g == i-1));
     g_real(:, :, j) = g_realCh1;
    end
end
subplot(224),
imshow(g_real)
% colormap(cmap)
axis image
title('Averaged grayscale')


