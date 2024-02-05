import requests
import psycopg2
import schedule
import time
import os

DBpassword = os.getenv('SQLPASS')

def fetch_and_store_data():
    # API data FETCH
    response = requests.get("https://4feaquhyai.execute-api.us-east-1.amazonaws.com/api/pi")
    data = response.json()

    # connecting to sql DB
    conn = psycopg2.connect(f"dbname='enjubzhr' user='enjubzhr' host='berry.db.elephantsql.com' password={DBpassword}")
    cur = conn.cursor()
    # inserting insert_query into DB
    insert_query = "INSERT INTO pi_data (factor, pi_value, time) VALUES (%s, %s, %s)"
    cur.execute(insert_query, (data['factor'], data['pi'], data['time']))
    # need to commit connection for this to work
    conn.commit()

    #closing curser and connection
    cur.close()
    conn.close()

# call the fetchandds func starting at 00 minutes and finishing at 59 minutes
schedule.every().minute.at(":00").do(fetch_and_store_data)
while True:
    schedule.run_pending()
    time.sleep(1)
