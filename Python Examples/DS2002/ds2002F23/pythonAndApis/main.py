import requests
import pandas as pd
import json
import matplotlib.pyplot as plt

URL = "https://yfapi.net/v6/finance/quote"
# secondURL = "https://yfapi.net/v11/finance/quoteSummary/"
API_KEY = "xOg9S6BDaM63r3DypoIIp6rK9LlwkCM17VpCJHRs" 

def fetch_stock_details(ticker):
    headers = {
        "x-api-key": f"{API_KEY}"
    }
    querystring={"symbols":f"{ticker}"}
    # Fetch Stock Details
    response = requests.request("GET", URL, headers=headers, params=querystring)
    response.raise_for_status()  # Raise an exception for HTTP errors

    stock_data = response.json()

    result = stock_data["quoteResponse"]["result"][0]

    ticker = result["symbol"]
    full_name = result["longName"]
    current_price = result["ask"]
    target_mean_price = result["fiftyDayAverage"]
    cash_on_hand = target_mean_price * int(result["regularMarketVolume"])
    gross_profits = result["marketCap"]
    
    return ticker, full_name, current_price, target_mean_price, cash_on_hand, gross_profits
    # return stock_data

def save_to_files(data):
    # Save to JSON
    with open("stock_data.json", "w") as json_file:
        json.dump(data, json_file)

    # Save to CSV
    df = pd.DataFrame([data], columns=["Ticker", "Full Name", "Current Price", "Target Mean Price", "Cash On Hand", "Gross Profits"])
    df.to_csv("stock_data.csv", index=False)


if __name__ == "__main__":
    ticker = input("Enter the stock ticker symbol: ").upper()

    try:
        data = fetch_stock_details(ticker)
        print("\nStock Details:")
        print(f"Ticker: {data[0]}\nFull Name: {data[1]}\nCurrent Price: {data[2]}\nTarget Mean Price: {data[3]}\nCash On Hand: {data[4]}\nGross Profits: {data[5]}")
        # print(data)
        
        save_to_files(data)
        # plot_stock_price(ticker)
    except requests.exceptions.HTTPError:
        print("Error fetching data. Please check if the stock ticker exists or if there are any API issues.")
