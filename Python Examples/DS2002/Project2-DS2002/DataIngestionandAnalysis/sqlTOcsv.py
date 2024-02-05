import psycopg2
import csv

##########################################################################
####### WRITING ALL DATA FROM DB INTO A CSV FILE FOR DATA ANALYSIS #######
##########################################################################

# init db information
# bad practice but my dot env is acting weird
dbname = 'enjubzhr'
user = 'enjubzhr'
host = 'berry.db.elephantsql.com'
password = 'NrwAK4dcHIljxAqqtkhrxclcQTrOX7VU'
output_path = './pi_data.csv'
# connect to db and create our new cuser with conn
conn = psycopg2.connect(dbname=dbname, user=user, host=host, password=password)
cur = conn.cursor()
# need a query to select all the pi data then send the query
query = "SELECT * FROM pi_data;"
cur.execute(query)
# Fetch all the results
results = cur.fetchall()
# now put results into csv file using csv import
# writerow and writerows (HEADERS AND DATA)
with open(output_path, 'w', newline='') as csvfile:
    csvwriter = csv.writer(csvfile)
    csvwriter.writerow([i[0] for i in cur.description])
    csvwriter.writerows(results)
# close conn and cur
cur.close()
conn.close()
print(f"IT WORKED!?{output_path}")
