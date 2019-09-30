1. Select countries where a total number of inhabitants (population) in all cities is greater than 400:

					SELECT * FROM Country c WHERE c.CountryID NOT IN
					(
						SELECT co.CountryID
						FROM Country co
						JOIN City ci
						ON co.CountryID = ci.CountryID
						WHERE ci.Population <= 400
					);
					


2. Select names of the countries that have no buildings at all:

					SELECT * FROM Country c WHERE NOT EXISTS
					(
						SELECT ci.CountryID FROM City ci
						JOIN Building b
						ON ci.CityID = b.CityID
						WHERE c.CountryID = ci.CountryID
					);