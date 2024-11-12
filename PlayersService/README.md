# Players Service
#### Author: Anas Nasrallah<br>
### Implementation Notes:<br>
* In a try to make the implementation flexible, the csv parsing can be controlled by these application properties: <br>
app.csv_parser.csv_file_path<br>
app.csv_parser.should_parse<br>
* For the parsing to take place a file path needs to be specified and should_parse<br>
flag should be true. Otherwise, the application will start without parsing.
* I added the players.csv to the project files so that it will be parsed if someone<br>
would like to run it on another machine.
* A cache was implemented as an optimization
* An index was added to the table (for player_id)
* Regarding the values of the columns throws and bats, I thought it meant what hand<br>
the player uses, so I implemented a ENUM (L,R,B) but then I saw a value S. I concluded<br>
that it may mean something else, so I implemented as String
* I tried not to change the names of the fields. For example, I didn't rename nameFirst to<br>
firstName which is better in my opinion.
* For deployment, I created a DockerFile and deployment.yml, but I couldn't test them<br>
I'm aware that these files needs further investigation

### Things I would have done if I had more time:<br>
* Implement a rate limit mechanism
* Implement unit tests
* Better manage DB users
* Implement more advanced parsing features like importing the csv file from<br>
an external storage.
* Add metrics (for example for parsing errors or not found requests)
* Manage deployment
