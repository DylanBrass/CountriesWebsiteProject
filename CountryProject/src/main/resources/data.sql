INSERT INTO Modern_Flag
(DATE_FIRST_USED,DESCRIPTION,FLAG_URL,CREATOR)
VALUES
    ('1794-02-15','A vertical tricolour of blue, white, and red',
     'https://upload.wikimedia.org/wikipedia/en/thumb/c/c3/Flag_of_France.svg/1024px-Flag_of_France.svg.png'
        ,'Jacques-Louis David Lafayette');

INSERT INTO Countries
    (country_name,description,date_founded,flag_past_url,modern_flag_id,map_url,history_text)
VALUES
('France',
 'France, in Western Europe, encompasses medieval cities, alpine villages and Mediterranean beaches. Paris, its capital, is famed for its fashion houses, classical art museums including the Louvre and monuments like the Eiffel Tower.'
 ,'1872-09-22'
,'https://frenchmoments.eu/wp-content/uploads/2015/05/French-Flag-before-1790.png',1,'france/fr-departments.json','Inhabited since the Palaeolithic era, the territory of Metropolitan France was settled by Celtic tribes known as Gauls during the Iron Age. Rome annexed the area in 51 BC, leading to a distinct Gallo-Roman culture that laid the foundation of the French language. The Germanic Franks formed the Kingdom of Francia, which became the heartland of the Carolingian Empire. The Treaty of Verdun of 843 partitioned the empire, with West Francia becoming the Kingdom of France in 987. In the High Middle Ages, France was a powerful but highly decentralised feudal kingdom. Philip II successfully strengthened royal power and defeated his rivals to double the size of the crown lands; by the end of his reign, France had emerged as the most powerful state in Europe. From the mid-14th to the mid-15th century, France was plunged into a series of dynastic conflicts involving England, collectively known as the Hundred Years'' War, and a distinct French identity emerged as a result. The French Renaissance saw art and culture flourish, conflict with the House of Habsburg, and the establishment of a global colonial empire, which by the 20th century would become the second-largest in the world.[15] The second half of the 16th century was dominated by religious civil wars between Catholics and Huguenots that severely weakened the country. France again emerged as Europe''s dominant power in the 17th century under Louis XIV following the Thirty Years'' War.[16] Inadequate economic policies, inequitable taxes and frequent wars (notably a defeat in the Seven Years'' War and costly involvement in the American War of Independence) left the kingdom in a precarious economic situation by the end of the 18th century. This precipitated the French Revolution of 1789, which overthrew the Ancien Régime and produced the Declaration of the Rights of Man, which expresses the nation''s ideals to this day.

France reached its political and military zenith in the early 19th century under Napoleon Bonaparte, subjugating much of continental Europe and establishing the First French Empire. The French Revolutionary and Napoleonic Wars shaped the course of European and world history. The collapse of the empire initiated a period of relative decline, in which France endured a tumultuous succession of governments until the founding of the French Third Republic during the Franco-Prussian War in 1870. Subsequent decades saw a period of optimism, cultural and scientific flourishing, as well as economic prosperity, known as the Belle Époque. France was one of the major participants of World War I, from which it emerged victorious at a great human and economic cost. It was among the Allied powers of World War II but was soon occupied by the Axis in 1940. Following liberation in 1944, the short-lived Fourth Republic was established and later dissolved in the course of the Algerian War. The current Fifth Republic was formed in 1958 by Charles de Gaulle. Algeria and most French colonies became independent in the 1960s, with the majority retaining close economic and military ties with France.

France retains its centuries-long status as a global centre of art, science and philosophy. It hosts the fifth-largest number of UNESCO World Heritage Sites and is the world''s leading tourist destination, receiving over 89 million foreign visitors in 2018.[17] France is a developed country ranked 28th in the Human Development Index, with the world''s seventh-largest economy by nominal GDP and tenth-largest by PPP; in terms of aggregate household wealth, it ranks fourth in the world.[18] France performs well in international rankings of education, health care, and life expectancy. It remains a great power in global affairs,[19] being one of the five permanent members of the United Nations Security Council and an official nuclear-weapon state. France is a founding and leading member of the European Union and the Eurozone,[20] as well as a key member of the Group of Seven, North Atlantic Treaty Organization (NATO), Organisation for Economic Co-operation and Development (OECD) and Francophonie.');


INSERT INTO Modern_Flag
(DATE_FIRST_USED,DESCRIPTION,FLAG_URL,CREATOR)
VALUES
    ('1848-03-09','A horizontal tricolour of black, red, and gold',
     'https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/Flag_of_Germany.svg/383px-Flag_of_Germany.svg.png'
        ,'Disputed');
INSERT INTO
    Countries
(country_name,description,date_founded,flag_past_url,modern_flag_id,map_url )
VALUES ('Germany',
        'Germany is a Western European country. It has over 2 millennia of history. Berlin, its capital, is home to art and nightlife scenes, the Brandenburg Gate and many sites relating to WWII.',
         '1949-05-23','https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Flag_of_Germany_%281867%E2%80%931918%29.svg/255px-Flag_of_Germany_%281867%E2%80%931918%29.svg.png'
         ,2,'germany/germany-regions.json');


INSERT INTO QUESTIONS (ANSWER,FAKE_ANSWER_ONE,FAKE_ANSWER_TWO,FAKE_ANSWER_THREE,QUESTION,COUNTRY_ID) VALUES ('French','German','Joile','English','What language do they speak in France',1);

INSERT INTO QUESTIONS (ANSWER,FAKE_ANSWER_ONE,FAKE_ANSWER_TWO,FAKE_ANSWER_THREE,QUESTION,COUNTRY_ID) VALUES ('Paris','Berlin','Quebec','Brest','What is the capital of France',1);

INSERT INTO QUESTIONS (ANSWER,FAKE_ANSWER_ONE,FAKE_ANSWER_TWO,FAKE_ANSWER_THREE,QUESTION,COUNTRY_ID) VALUES ('Rooster','Cow','Bull','Unicorn','What is the national animal of France',1);



INSERT INTO QUESTIONS (ANSWER,FAKE_ANSWER_ONE,FAKE_ANSWER_TWO,FAKE_ANSWER_THREE,QUESTION,COUNTRY_ID) VALUES ('German','French','Spanish','English','What language do they speak in Germany',2);

INSERT INTO QUESTIONS (ANSWER,FAKE_ANSWER_ONE,FAKE_ANSWER_TWO,FAKE_ANSWER_THREE,QUESTION,COUNTRY_ID) VALUES ('Berlin','Munich','Warsaw','Brest','What is the capital of Germany',2);

INSERT INTO QUESTIONS (ANSWER,FAKE_ANSWER_ONE,FAKE_ANSWER_TWO,FAKE_ANSWER_THREE,QUESTION,COUNTRY_ID) VALUES ('Weimar eagle','Beaver','Horse','German Shepherd','What is the national animal of Germany',2);