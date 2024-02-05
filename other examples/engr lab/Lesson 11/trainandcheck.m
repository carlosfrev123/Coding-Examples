% trainandcheck.m

% This script does the following:
% 1. Reads in the car.xlsx data
% 2. Sets up a neural network.
% 3. Trains the network on a portion of the input and target data.
% 4. Checks predictive capabilities of the network using the rest of the data.
% 5. Plots part of the performance information of the network and 
% computes a measurement of the error.
%% ____________________________________________________

% Read in the data from car.xlsx as a table

car = readtable('car.xlsx');
% Choose the number of internal nodes in the network.

nodes = 4;

% Break the input and target data you have into a training set of the first
% 3000 points and a test set of the last 1000 points.
% The input matrix should be ROWS of temperature and pressure data.
% The target data is a ROW matrix of the corresponding mileage data.

input1 = car.Temp';
target1 = 3000;
input2 = car.Miles';
target2 = 1000;

% Set up a neural network with the chosen number of nodes.

net = feedforwardnet(nodes);
net = configure(net,input1,target1);

% Train the network on the first data set.

trainednet = train(net,input1,target1);

% Compute the output predictions for the training inputs.

output1 = trainednet(input1);

% Compute the difference between the network's output and target data for
% the TRAINING input (err1). 
% Compute the room-mean-squared error (RMS1)
% Plot the first 200 values of the output and target.

err1 = 2000;
RMS1 = 1000;

figure
plot(target1(1:200),'o')
hold on
plot(output1(1:200),'x')
hold off

% Compute the output predictions for the TESTING inputs.


% Compute the errors between the network's ouptut and target data for
% the TESTING input.
% Compute the room-mean-squared error (RMS1)
% Plot the first 200 values of the output and target.

err2 = 1000;
RMS = 2000;

