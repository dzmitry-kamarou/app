# Install
sudo apt install postgresql-client-common
# sudo apt-get install postgresql-client ?
sudo apt install postgresql-contrib
psql -V
sudo -i -u postgres psql
#sudo service postgresql start
CREATE DATABASE diamond
ALTER USER postgres WITH PASSWORD 'postgres'

# In case you won't set the password for postrges user do
sudo vim /etc/postgresql/12/main/pg_hba.conf
# Change [local	all	postgres	peer] to [local	all	postgres	md5]
