# European Country Knowledge
Back End


# What is this project
This project is for our final work in our Java Web class

# Description
The website is a sort of dictionary where information was gathered (quickly not professionally) and put together.

There is a list of countries and a page which it is possible to answer questions.

The questions page is composed of a component that displays it and, in the component, there is a verify button that tells you if you answered correctly or not. In the countries page there is two buttons on each country component, one of them brings you to a 'details' page with an interactive map and the others to the quiz page but with only questions that are for that specific country.



# Technologies

It uses spring boot with java (version 17 with jdk 17 also) and Graddle Groovy

These are the dependencies :
```gradle
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.springframework.boot:spring-boot-starter-validation'
	compileOnly 'org.projectlombok:lombok'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'com.h2database:h2'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}
```

The important ones are lombok, Spring Web and the H2 database
The file structure of my main : 

![image](https://user-images.githubusercontent.com/71225455/209450725-156ed5f4-0733-4864-b21b-3b0dc78f63c2.png)

My project follows REST API infrastructure so it has a controller, service, entity and response/request for my tables

# Running the project
To run the project you simply need to download node module for this react app. And then start my backend code (we use intellij) and run it on port 8080. Since the package.json is still there you do not need to redownload the libraries used.

My front end is here : (https://github.com/DylanBrass/Java_Web_Final_Project#readme)


# Challenges 

### PUT on a question

This was the hardest part because of the amount of information that was being sent because of a mistake I made, I was requesting a Country that was requesting a Flag

I ended up cleaning my code and having this simple request :

```java
package com.example.countryproject.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class QuestionRequest {
    @NotBlank
    private String question;
    @NotBlank
    private String answer;
    @NotBlank
    private String fakeAnswerOne;
    @NotBlank
    private String fakeAnswerTwo;
    @NotBlank
    private String fakeAnswerThree;

}
```


### Modifying the questions country

I could no succeed in doing so, because of what I previously said, it required me to request a country that would request a flag...

I tried calling by Id the country If I could send it, it was in vain

# Design

The design is extremely simple because it follows REST architecture.

Meaning that and Entity like Country will have a controller and a service, but on the other hand an entity who can only exist if another exist such as modernFlag, it is called with the country controller, service and reposotory.

My table structure is shown below.


# Database Structure 

![image](https://user-images.githubusercontent.com/71225455/209451175-5d7bbdc0-722e-4457-ae69-b892fa376818.png)



# End Points 


## Questions 

GET /api/questions 

returns 200 if found or 400 if not found
Example of a response : 
```json
[
    {
        "Id": 1,
        "Question": "What language do they speak in France ?",
        "Answer": "French",
        "FakeAnswerOne": "German",
        "FakeAnswerTwo": "Joile",
        "FakeAnswerThree": "English",
        "country": {
            "id": 1,
            "countryName": "France",
            "description": "France, in Western Europe, encompasses medieval cities, alpine villages and Mediterranean beaches. Paris, its capital, is famed for its fashion houses, classical art museums including the Louvre and monuments like the Eiffel Tower.",
            "dateFounded": "1872-09-22",
            "famousFlagPast": "https://frenchmoments.eu/wp-content/uploads/2015/05/French-Flag-before-1790.png",
            "map": "france/fr-departments.json",
            "history": "Inhabited since the Palaeolithic era, the territory of Metropolitan France was settled by Celtic tribes known as Gauls during the Iron Age. Rome annexed the area in 51 BC, leading to a distinct Gallo-Roman culture that laid the foundation of the French language. The Germanic Franks formed the Kingdom of Francia, which became the heartland of the Carolingian Empire. The Treaty of Verdun of 843 partitioned the empire, with West Francia becoming the Kingdom of France in 987. In the High Middle Ages, France was a powerful but highly decentralised feudal kingdom. Philip II successfully strengthened royal power and defeated his rivals to double the size of the crown lands; by the end of his reign, France had emerged as the most powerful state in Europe. From the mid-14th to the mid-15th century, France was plunged into a series of dynastic conflicts involving England, collectively known as the Hundred Years' War, and a distinct French identity emerged as a result. The French Renaissance saw art and culture flourish, conflict with the House of Habsburg, and the establishment of a global colonial empire, which by the 20th century would become the second-largest in the world.[15] The second half of the 16th century was dominated by religious civil wars between Catholics and Huguenots that severely weakened the country. France again emerged as Europe's dominant power in the 17th century under Louis XIV following the Thirty Years' War.[16] Inadequate economic policies, inequitable taxes and frequent wars (notably a defeat in the Seven Years' War and costly involvement in the American War of Independence) left the kingdom in a precarious economic situation by the end of the 18th century. This precipitated the French Revolution of 1789, which overthrew the Ancien Régime and produced the Declaration of the Rights of Man, which expresses the nation's ideals to this day.\n\nFrance reached its political and military zenith in the early 19th century under Napoleon Bonaparte, subjugating much of continental Europe and establishing the First French Empire. The French Revolutionary and Napoleonic Wars shaped the course of European and world history. The collapse of the empire initiated a period of relative decline, in which France endured a tumultuous succession of governments until the founding of the French Third Republic during the Franco-Prussian War in 1870. Subsequent decades saw a period of optimism, cultural and scientific flourishing, as well as economic prosperity, known as the Belle Époque. France was one of the major participants of World War I, from which it emerged victorious at a great human and economic cost. It was among the Allied powers of World War II but was soon occupied by the Axis in 1940. Following liberation in 1944, the short-lived Fourth Republic was established and later dissolved in the course of the Algerian War. The current Fifth Republic was formed in 1958 by Charles de Gaulle. Algeria and most French colonies became independent in the 1960s, with the majority retaining close economic and military ties with France.\n\nFrance retains its centuries-long status as a global centre of art, science and philosophy. It hosts the fifth-largest number of UNESCO World Heritage Sites and is the world's leading tourist destination, receiving over 89 million foreign visitors in 2018.[17] France is a developed country ranked 28th in the Human Development Index, with the world's seventh-largest economy by nominal GDP and tenth-largest by PPP; in terms of aggregate household wealth, it ranks fourth in the world.[18] France performs well in international rankings of education, health care, and life expectancy. It remains a great power in global affairs,[19] being one of the five permanent members of the United Nations Security Council and an official nuclear-weapon state. France is a founding and leading member of the European Union and the Eurozone,[20] as well as a key member of the Group of Seven, North Atlantic Treaty Organization (NATO), Organisation for Economic Co-operation and Development (OECD) and Francophonie.",
            "modernFlag": {
                "id": 1,
                "creator": "Jacques-Louis David Lafayette",
                "description": "A vertical tricolour of blue, white, and red",
                "flagPhoto": "https://upload.wikimedia.org/wikipedia/en/thumb/c/c3/Flag_of_France.svg/1024px-Flag_of_France.svg.png",
                "dateUsed": "1794-02-15"
            }
        }
    },
    {
        "Id": 2,
        "Question": "What is the capital of France ?",
        "Answer": "Paris",
        "FakeAnswerOne": "Berlin",
        "FakeAnswerTwo": "Quebec",
        "FakeAnswerThree": "Brest",
        "country": {
            "id": 1,
            "countryName": "France",
            "description": "France, in Western Europe, encompasses medieval cities, alpine villages and Mediterranean beaches. Paris, its capital, is famed for its fashion houses, classical art museums including the Louvre and monuments like the Eiffel Tower.",
            "dateFounded": "1872-09-22",
            "famousFlagPast": "https://frenchmoments.eu/wp-content/uploads/2015/05/French-Flag-before-1790.png",
            "map": "france/fr-departments.json",
            "history": "Inhabited since the Palaeolithic era, the territory of Metropolitan France was settled by Celtic tribes known as Gauls during the Iron Age. Rome annexed the area in 51 BC, leading to a distinct Gallo-Roman culture that laid the foundation of the French language. The Germanic Franks formed the Kingdom of Francia, which became the heartland of the Carolingian Empire. The Treaty of Verdun of 843 partitioned the empire, with West Francia becoming the Kingdom of France in 987. In the High Middle Ages, France was a powerful but highly decentralised feudal kingdom. Philip II successfully strengthened royal power and defeated his rivals to double the size of the crown lands; by the end of his reign, France had emerged as the most powerful state in Europe. From the mid-14th to the mid-15th century, France was plunged into a series of dynastic conflicts involving England, collectively known as the Hundred Years' War, and a distinct French identity emerged as a result. The French Renaissance saw art and culture flourish, conflict with the House of Habsburg, and the establishment of a global colonial empire, which by the 20th century would become the second-largest in the world.[15] The second half of the 16th century was dominated by religious civil wars between Catholics and Huguenots that severely weakened the country. France again emerged as Europe's dominant power in the 17th century under Louis XIV following the Thirty Years' War.[16] Inadequate economic policies, inequitable taxes and frequent wars (notably a defeat in the Seven Years' War and costly involvement in the American War of Independence) left the kingdom in a precarious economic situation by the end of the 18th century. This precipitated the French Revolution of 1789, which overthrew the Ancien Régime and produced the Declaration of the Rights of Man, which expresses the nation's ideals to this day.\n\nFrance reached its political and military zenith in the early 19th century under Napoleon Bonaparte, subjugating much of continental Europe and establishing the First French Empire. The French Revolutionary and Napoleonic Wars shaped the course of European and world history. The collapse of the empire initiated a period of relative decline, in which France endured a tumultuous succession of governments until the founding of the French Third Republic during the Franco-Prussian War in 1870. Subsequent decades saw a period of optimism, cultural and scientific flourishing, as well as economic prosperity, known as the Belle Époque. France was one of the major participants of World War I, from which it emerged victorious at a great human and economic cost. It was among the Allied powers of World War II but was soon occupied by the Axis in 1940. Following liberation in 1944, the short-lived Fourth Republic was established and later dissolved in the course of the Algerian War. The current Fifth Republic was formed in 1958 by Charles de Gaulle. Algeria and most French colonies became independent in the 1960s, with the majority retaining close economic and military ties with France.\n\nFrance retains its centuries-long status as a global centre of art, science and philosophy. It hosts the fifth-largest number of UNESCO World Heritage Sites and is the world's leading tourist destination, receiving over 89 million foreign visitors in 2018.[17] France is a developed country ranked 28th in the Human Development Index, with the world's seventh-largest economy by nominal GDP and tenth-largest by PPP; in terms of aggregate household wealth, it ranks fourth in the world.[18] France performs well in international rankings of education, health care, and life expectancy. It remains a great power in global affairs,[19] being one of the five permanent members of the United Nations Security Council and an official nuclear-weapon state. France is a founding and leading member of the European Union and the Eurozone,[20] as well as a key member of the Group of Seven, North Atlantic Treaty Organization (NATO), Organisation for Economic Co-operation and Development (OECD) and Francophonie.",
            "modernFlag": {
                "id": 1,
                "creator": "Jacques-Louis David Lafayette",
                "description": "A vertical tricolour of blue, white, and red",
                "flagPhoto": "https://upload.wikimedia.org/wikipedia/en/thumb/c/c3/Flag_of_France.svg/1024px-Flag_of_France.svg.png",
                "dateUsed": "1794-02-15"
            }
        }
    },
    {
        "Id": 3,
        "Question": "What is the national animal of France ?",
        "Answer": "Rooster",
        "FakeAnswerOne": "Cow",
        "FakeAnswerTwo": "Bull",
        "FakeAnswerThree": "Unicorn",
        "country": {
            "id": 1,
            "countryName": "France",
            "description": "France, in Western Europe, encompasses medieval cities, alpine villages and Mediterranean beaches. Paris, its capital, is famed for its fashion houses, classical art museums including the Louvre and monuments like the Eiffel Tower.",
            "dateFounded": "1872-09-22",
            "famousFlagPast": "https://frenchmoments.eu/wp-content/uploads/2015/05/French-Flag-before-1790.png",
            "map": "france/fr-departments.json",
            "history": "Inhabited since the Palaeolithic era, the territory of Metropolitan France was settled by Celtic tribes known as Gauls during the Iron Age. Rome annexed the area in 51 BC, leading to a distinct Gallo-Roman culture that laid the foundation of the French language. The Germanic Franks formed the Kingdom of Francia, which became the heartland of the Carolingian Empire. The Treaty of Verdun of 843 partitioned the empire, with West Francia becoming the Kingdom of France in 987. In the High Middle Ages, France was a powerful but highly decentralised feudal kingdom. Philip II successfully strengthened royal power and defeated his rivals to double the size of the crown lands; by the end of his reign, France had emerged as the most powerful state in Europe. From the mid-14th to the mid-15th century, France was plunged into a series of dynastic conflicts involving England, collectively known as the Hundred Years' War, and a distinct French identity emerged as a result. The French Renaissance saw art and culture flourish, conflict with the House of Habsburg, and the establishment of a global colonial empire, which by the 20th century would become the second-largest in the world.[15] The second half of the 16th century was dominated by religious civil wars between Catholics and Huguenots that severely weakened the country. France again emerged as Europe's dominant power in the 17th century under Louis XIV following the Thirty Years' War.[16] Inadequate economic policies, inequitable taxes and frequent wars (notably a defeat in the Seven Years' War and costly involvement in the American War of Independence) left the kingdom in a precarious economic situation by the end of the 18th century. This precipitated the French Revolution of 1789, which overthrew the Ancien Régime and produced the Declaration of the Rights of Man, which expresses the nation's ideals to this day.\n\nFrance reached its political and military zenith in the early 19th century under Napoleon Bonaparte, subjugating much of continental Europe and establishing the First French Empire. The French Revolutionary and Napoleonic Wars shaped the course of European and world history. The collapse of the empire initiated a period of relative decline, in which France endured a tumultuous succession of governments until the founding of the French Third Republic during the Franco-Prussian War in 1870. Subsequent decades saw a period of optimism, cultural and scientific flourishing, as well as economic prosperity, known as the Belle Époque. France was one of the major participants of World War I, from which it emerged victorious at a great human and economic cost. It was among the Allied powers of World War II but was soon occupied by the Axis in 1940. Following liberation in 1944, the short-lived Fourth Republic was established and later dissolved in the course of the Algerian War. The current Fifth Republic was formed in 1958 by Charles de Gaulle. Algeria and most French colonies became independent in the 1960s, with the majority retaining close economic and military ties with France.\n\nFrance retains its centuries-long status as a global centre of art, science and philosophy. It hosts the fifth-largest number of UNESCO World Heritage Sites and is the world's leading tourist destination, receiving over 89 million foreign visitors in 2018.[17] France is a developed country ranked 28th in the Human Development Index, with the world's seventh-largest economy by nominal GDP and tenth-largest by PPP; in terms of aggregate household wealth, it ranks fourth in the world.[18] France performs well in international rankings of education, health care, and life expectancy. It remains a great power in global affairs,[19] being one of the five permanent members of the United Nations Security Council and an official nuclear-weapon state. France is a founding and leading member of the European Union and the Eurozone,[20] as well as a key member of the Group of Seven, North Atlantic Treaty Organization (NATO), Organisation for Economic Co-operation and Development (OECD) and Francophonie.",
            "modernFlag": {
                "id": 1,
                "creator": "Jacques-Louis David Lafayette",
                "description": "A vertical tricolour of blue, white, and red",
                "flagPhoto": "https://upload.wikimedia.org/wikipedia/en/thumb/c/c3/Flag_of_France.svg/1024px-Flag_of_France.svg.png",
                "dateUsed": "1794-02-15"
            }
        }
    },
    {
        "Id": 4,
        "Question": "What language do they speak in Germany ?",
        "Answer": "German",
        "FakeAnswerOne": "French",
        "FakeAnswerTwo": "Spanish",
        "FakeAnswerThree": "English",
        "country": {
            "id": 2,
            "countryName": "Germany",
            "description": "Germany is a Western European country. It has over 2 millennia of history. Berlin, its capital, is home to art and nightlife scenes, the Brandenburg Gate and many sites relating to WWII.",
            "dateFounded": "1949-05-23",
            "famousFlagPast": "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Flag_of_Germany_%281867%E2%80%931918%29.svg/255px-Flag_of_Germany_%281867%E2%80%931918%29.svg.png",
            "map": "germany/germany-regions.json",
            "history": "Various Germanic tribes have inhabited the northern parts of modern Germany since classical antiquity. A region named Germania was documented before AD 100. In 962, the Kingdom of Germany formed the bulk of the Holy Roman Empire. During the 16th century, northern German regions became the centre of the Protestant Reformation. Following the Napoleonic Wars and the dissolution of the Holy Roman Empire in 1806, the German Confederation was formed in 1815.\n\nFormal unification of Germany into the modern nation-state was commenced on 18 August 1866 with the North German Confederation Treaty establishing the Prussia-led North German Confederation later transformed in 1871 into the German Empire. After World War I and the German Revolution of 1918–1919, the Empire was in turn transformed into the semi-presidential Weimar Republic. The Nazi seizure of power in 1933 led to the establishment of a totalitarian dictatorship, World War II, and the Holocaust. After the end of World War II in Europe and a period of Allied occupation, Germany as a whole was organized into two separate polities with limited sovereignity: the Federal Republic of Germany, generally known as West Germany, and the German Democratic Republic, East Germany, while Berlin continued its Four Power status. The Federal Republic of Germany was a founding member of the European Economic Community and the European Union, while the German Democratic Republic was a communist Eastern Bloc state and member of the Warsaw Pact. After the fall of communism, German reunification saw the former East German states join the Federal Republic of Germany on 3 October 1990—becoming a federal parliamentary republic.\n\nGermany is a great power with a strong economy; it has the largest economy in Europe, the world's fourth-largest economy by nominal GDP and the fifth-largest by PPP. As a global power in industrial, scientific and technological sectors, it is both the world's third-largest exporter and importer. As a highly developed country, which ranks ninth on the Human Development Index, it offers social security and a universal health care system, environmental protections, a tuition-free university education, and it is ranked as sixteenth-most peaceful country in the world. Germany is a member of the United Nations, the European Union, NATO, the Council of Europe, the G7, the G20 and the OECD. It has the third-greatest number of UNESCO World Heritage Sites, the most entries in the Memory of the World International Register and the 3rd most Nobel laureates.",
            "modernFlag": {
                "id": 2,
                "creator": "Disputed",
                "description": "A horizontal tricolour of black, red, and gold",
                "flagPhoto": "https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/Flag_of_Germany.svg/383px-Flag_of_Germany.svg.png",
                "dateUsed": "1848-03-09"
            }
        }
    },
    {
        "Id": 5,
        "Question": "What is the capital of Germany ?",
        "Answer": "Berlin",
        "FakeAnswerOne": "Munich",
        "FakeAnswerTwo": "Warsaw",
        "FakeAnswerThree": "Brest",
        "country": {
            "id": 2,
            "countryName": "Germany",
            "description": "Germany is a Western European country. It has over 2 millennia of history. Berlin, its capital, is home to art and nightlife scenes, the Brandenburg Gate and many sites relating to WWII.",
            "dateFounded": "1949-05-23",
            "famousFlagPast": "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Flag_of_Germany_%281867%E2%80%931918%29.svg/255px-Flag_of_Germany_%281867%E2%80%931918%29.svg.png",
            "map": "germany/germany-regions.json",
            "history": "Various Germanic tribes have inhabited the northern parts of modern Germany since classical antiquity. A region named Germania was documented before AD 100. In 962, the Kingdom of Germany formed the bulk of the Holy Roman Empire. During the 16th century, northern German regions became the centre of the Protestant Reformation. Following the Napoleonic Wars and the dissolution of the Holy Roman Empire in 1806, the German Confederation was formed in 1815.\n\nFormal unification of Germany into the modern nation-state was commenced on 18 August 1866 with the North German Confederation Treaty establishing the Prussia-led North German Confederation later transformed in 1871 into the German Empire. After World War I and the German Revolution of 1918–1919, the Empire was in turn transformed into the semi-presidential Weimar Republic. The Nazi seizure of power in 1933 led to the establishment of a totalitarian dictatorship, World War II, and the Holocaust. After the end of World War II in Europe and a period of Allied occupation, Germany as a whole was organized into two separate polities with limited sovereignity: the Federal Republic of Germany, generally known as West Germany, and the German Democratic Republic, East Germany, while Berlin continued its Four Power status. The Federal Republic of Germany was a founding member of the European Economic Community and the European Union, while the German Democratic Republic was a communist Eastern Bloc state and member of the Warsaw Pact. After the fall of communism, German reunification saw the former East German states join the Federal Republic of Germany on 3 October 1990—becoming a federal parliamentary republic.\n\nGermany is a great power with a strong economy; it has the largest economy in Europe, the world's fourth-largest economy by nominal GDP and the fifth-largest by PPP. As a global power in industrial, scientific and technological sectors, it is both the world's third-largest exporter and importer. As a highly developed country, which ranks ninth on the Human Development Index, it offers social security and a universal health care system, environmental protections, a tuition-free university education, and it is ranked as sixteenth-most peaceful country in the world. Germany is a member of the United Nations, the European Union, NATO, the Council of Europe, the G7, the G20 and the OECD. It has the third-greatest number of UNESCO World Heritage Sites, the most entries in the Memory of the World International Register and the 3rd most Nobel laureates.",
            "modernFlag": {
                "id": 2,
                "creator": "Disputed",
                "description": "A horizontal tricolour of black, red, and gold",
                "flagPhoto": "https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/Flag_of_Germany.svg/383px-Flag_of_Germany.svg.png",
                "dateUsed": "1848-03-09"
            }
        }
    }
```


Response Schema :

```json
{
  "$schema": "http://json-schema.org/draft-04/schema#",
  "type": "object",
  "properties": {
    "Id": {
      "type": "integer"
    },
    "Question": {
      "type": "string"
    },
    "Answer": {
      "type": "string"
    },
    "FakeAnswerOne": {
      "type": "string"
    },
    "FakeAnswerTwo": {
      "type": "string"
    },
    "FakeAnswerThree": {
      "type": "string"
    },
    "country": {
      "type": "object",
      "properties": {
        "id": {
          "type": "integer"
        },
        "countryName": {
          "type": "string"
        },
        "description": {
          "type": "string"
        },
        "dateFounded": {
          "type": "string"
        },
        "famousFlagPast": {
          "type": "string"
        },
        "map": {
          "type": "string"
        },
        "history": {
          "type": "string"
        },
        "modernFlag": {
          "type": "object",
          "properties": {
            "id": {
              "type": "integer"
            },
            "creator": {
              "type": "string"
            },
            "description": {
              "type": "string"
            },
            "flagPhoto": {
              "type": "string"
            },
            "dateUsed": {
              "type": "string"
            }
          },
          "required": [
            "id",
            "creator",
            "description",
            "flagPhoto",
            "dateUsed"
          ]
        }
      },
      "required": [
        "id",
        "countryName",
        "description",
        "dateFounded",
        "famousFlagPast",
        "map",
        "history",
        "modernFlag"
      ]
    }
  },
  "required": [
    "Id",
    "Question",
    "Answer",
    "FakeAnswerOne",
    "FakeAnswerTwo",
    "FakeAnswerThree",
    "country"
  ]
}
```

PUT /api/questions/{id}
Returns 200 if it updated or 400 if not

DELETE /api/questions/{id}
return 200 if deleted or 400 if it failed


## Countries

GET /api/countries
return 200 if succeded or 400 if failed 

example response 
```json
[
    {
        "id": 1,
        "modernFlag": {
            "id": 1,
            "creator": "Jacques-Louis David Lafayette",
            "description": "A vertical tricolour of blue, white, and red",
            "flagPhoto": "https://upload.wikimedia.org/wikipedia/en/thumb/c/c3/Flag_of_France.svg/1024px-Flag_of_France.svg.png",
            "dateUsed": "1794-02-15"
        },
        "map": "france/fr-departments.json",
        "description": "France, in Western Europe, encompasses medieval cities, alpine villages and Mediterranean beaches. Paris, its capital, is famed for its fashion houses, classical art museums including the Louvre and monuments like the Eiffel Tower.",
        "dateFounded": "1872-09-22",
        "famousFlagPast": "https://frenchmoments.eu/wp-content/uploads/2015/05/French-Flag-before-1790.png",
        "countryName": "France",
        "historyText": "Inhabited since the Palaeolithic era, the territory of Metropolitan France was settled by Celtic tribes known as Gauls during the Iron Age. Rome annexed the area in 51 BC, leading to a distinct Gallo-Roman culture that laid the foundation of the French language. The Germanic Franks formed the Kingdom of Francia, which became the heartland of the Carolingian Empire. The Treaty of Verdun of 843 partitioned the empire, with West Francia becoming the Kingdom of France in 987. In the High Middle Ages, France was a powerful but highly decentralised feudal kingdom. Philip II successfully strengthened royal power and defeated his rivals to double the size of the crown lands; by the end of his reign, France had emerged as the most powerful state in Europe. From the mid-14th to the mid-15th century, France was plunged into a series of dynastic conflicts involving England, collectively known as the Hundred Years' War, and a distinct French identity emerged as a result. The French Renaissance saw art and culture flourish, conflict with the House of Habsburg, and the establishment of a global colonial empire, which by the 20th century would become the second-largest in the world.[15] The second half of the 16th century was dominated by religious civil wars between Catholics and Huguenots that severely weakened the country. France again emerged as Europe's dominant power in the 17th century under Louis XIV following the Thirty Years' War.[16] Inadequate economic policies, inequitable taxes and frequent wars (notably a defeat in the Seven Years' War and costly involvement in the American War of Independence) left the kingdom in a precarious economic situation by the end of the 18th century. This precipitated the French Revolution of 1789, which overthrew the Ancien Régime and produced the Declaration of the Rights of Man, which expresses the nation's ideals to this day.\n\nFrance reached its political and military zenith in the early 19th century under Napoleon Bonaparte, subjugating much of continental Europe and establishing the First French Empire. The French Revolutionary and Napoleonic Wars shaped the course of European and world history. The collapse of the empire initiated a period of relative decline, in which France endured a tumultuous succession of governments until the founding of the French Third Republic during the Franco-Prussian War in 1870. Subsequent decades saw a period of optimism, cultural and scientific flourishing, as well as economic prosperity, known as the Belle Époque. France was one of the major participants of World War I, from which it emerged victorious at a great human and economic cost. It was among the Allied powers of World War II but was soon occupied by the Axis in 1940. Following liberation in 1944, the short-lived Fourth Republic was established and later dissolved in the course of the Algerian War. The current Fifth Republic was formed in 1958 by Charles de Gaulle. Algeria and most French colonies became independent in the 1960s, with the majority retaining close economic and military ties with France.\n\nFrance retains its centuries-long status as a global centre of art, science and philosophy. It hosts the fifth-largest number of UNESCO World Heritage Sites and is the world's leading tourist destination, receiving over 89 million foreign visitors in 2018.[17] France is a developed country ranked 28th in the Human Development Index, with the world's seventh-largest economy by nominal GDP and tenth-largest by PPP; in terms of aggregate household wealth, it ranks fourth in the world.[18] France performs well in international rankings of education, health care, and life expectancy. It remains a great power in global affairs,[19] being one of the five permanent members of the United Nations Security Council and an official nuclear-weapon state. France is a founding and leading member of the European Union and the Eurozone,[20] as well as a key member of the Group of Seven, North Atlantic Treaty Organization (NATO), Organisation for Economic Co-operation and Development (OECD) and Francophonie."
    },
    {
        "id": 2,
        "modernFlag": {
            "id": 2,
            "creator": "Disputed",
            "description": "A horizontal tricolour of black, red, and gold",
            "flagPhoto": "https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/Flag_of_Germany.svg/383px-Flag_of_Germany.svg.png",
            "dateUsed": "1848-03-09"
        },
        "map": "germany/germany-regions.json",
        "description": "Germany is a Western European country. It has over 2 millennia of history. Berlin, its capital, is home to art and nightlife scenes, the Brandenburg Gate and many sites relating to WWII.",
        "dateFounded": "1949-05-23",
        "famousFlagPast": "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Flag_of_Germany_%281867%E2%80%931918%29.svg/255px-Flag_of_Germany_%281867%E2%80%931918%29.svg.png",
        "countryName": "Germany",
        "historyText": "Various Germanic tribes have inhabited the northern parts of modern Germany since classical antiquity. A region named Germania was documented before AD 100. In 962, the Kingdom of Germany formed the bulk of the Holy Roman Empire. During the 16th century, northern German regions became the centre of the Protestant Reformation. Following the Napoleonic Wars and the dissolution of the Holy Roman Empire in 1806, the German Confederation was formed in 1815.\n\nFormal unification of Germany into the modern nation-state was commenced on 18 August 1866 with the North German Confederation Treaty establishing the Prussia-led North German Confederation later transformed in 1871 into the German Empire. After World War I and the German Revolution of 1918–1919, the Empire was in turn transformed into the semi-presidential Weimar Republic. The Nazi seizure of power in 1933 led to the establishment of a totalitarian dictatorship, World War II, and the Holocaust. After the end of World War II in Europe and a period of Allied occupation, Germany as a whole was organized into two separate polities with limited sovereignity: the Federal Republic of Germany, generally known as West Germany, and the German Democratic Republic, East Germany, while Berlin continued its Four Power status. The Federal Republic of Germany was a founding member of the European Economic Community and the European Union, while the German Democratic Republic was a communist Eastern Bloc state and member of the Warsaw Pact. After the fall of communism, German reunification saw the former East German states join the Federal Republic of Germany on 3 October 1990—becoming a federal parliamentary republic.\n\nGermany is a great power with a strong economy; it has the largest economy in Europe, the world's fourth-largest economy by nominal GDP and the fifth-largest by PPP. As a global power in industrial, scientific and technological sectors, it is both the world's third-largest exporter and importer. As a highly developed country, which ranks ninth on the Human Development Index, it offers social security and a universal health care system, environmental protections, a tuition-free university education, and it is ranked as sixteenth-most peaceful country in the world. Germany is a member of the United Nations, the European Union, NATO, the Council of Europe, the G7, the G20 and the OECD. It has the third-greatest number of UNESCO World Heritage Sites, the most entries in the Memory of the World International Register and the 3rd most Nobel laureates."
    },
    {
        "id": 3,
        "modernFlag": null,
        "map": "turkey/turkiye.json",
        "description": "The Ottoman Empire, also known as the Turkish Empire, was an empire that controlled much of Southeast Europe, Western Asia, and Northern Africa between the 14th and early 20th centuries.",
        "dateFounded": "1299-01-26",
        "famousFlagPast": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Flag_of_the_Ottoman_Empire_%281844%E2%80%931922%29.svg/188px-Flag_of_the_Ottoman_Empire_%281844%E2%80%931922%29.svg.png",
        "countryName": "Ottoman Empire",
        "historyText": "\nUnder the reign of Suleiman the Magnificent, the Ottoman Empire marked the peak of its power and prosperity, as well as the highest development of its governmental, social, and economic systems.[26] At the beginning of the 17th century, the empire contained 32 provinces and numerous vassal states. Some of these were later absorbed into the Ottoman Empire, while others were granted various types of autonomy over the course of centuries.[m] With Constantinople (modern-day Istanbul) as its capital and control of lands around the Mediterranean Basin, the Ottoman Empire was at the centre of interactions between the Middle East and Europe for six centuries.\n\nWhile the empire was once thought to have entered a period of decline following the death of Suleiman the Magnificent, this view is no longer supported by the majority of academic historians.[28] The newer academic consensus posits that the empire continued to maintain a flexible and strong economy, society and military throughout the 17th and for much of the 18th century.[29] However, during a long period of peace from 1740 to 1768, the Ottoman military system fell behind that of its European rivals, the Habsburg and Russian empires.[30] The Ottomans consequently suffered severe military defeats in the late 18th and early 19th centuries. The successful Greek War of Independence concluded with decolonization of Greece following the London Protocol (1830) and Treaty of Constantinople (1832). This and other defeats prompted the Ottoman state to initiate a comprehensive process of reform and modernization known as the Tanzimat. Thus, over the course of the 19th century, the Ottoman state became vastly more powerful and organized internally, despite suffering further territorial losses, especially in the Balkans, where a number of new states emerged.[31]\n\nThe Committee of Union and Progress (CUP) established the Second Constitutional Era in the Young Turk Revolution in 1908, turning the Empire into a constitutional monarchy, which conducted competitive multi-party elections. However, after the disastrous Balkan Wars, the now radicalized and nationalistic CUP took over the government in the 1913 coup d'état, creating a one-party regime. The CUP allied the Empire with Germany, hoping to escape from the diplomatic isolation which had contributed to its recent territorial losses, and thus joined World War I on the side of the Central Powers.[32] While the Empire was able to largely hold its own during the conflict, it was struggling with internal dissent, especially with the Arab Revolt in its Arabian holdings. During this time, the Ottoman government engaged in genocide against the Armenians, Assyrians, and Greeks.[33] The Empire's defeat and the occupation of part of its territory by the Allied Powers in the aftermath of World War I resulted in its partitioning and the loss of its Middle Eastern territories, which were divided between the United Kingdom and France. The successful Turkish War of Independence, led by Mustafa Kemal Atatürk against the occupying Allies, led to the emergence of the Republic of Turkey in the Anatolian heartland and the abolition of the Ottoman monarchy."
    },
    {
        "id": 4,
        "modernFlag": {
            "id": 3,
            "creator": "Jaroslav Kursa",
            "description": "Two equal horizontal bands of white (top) and red with a blue isosceles triangle based on the hoist side.",
            "flagPhoto": "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Flag_of_the_Czech_Republic.svg/383px-Flag_of_the_Czech_Republic.svg.png",
            "dateUsed": "1920-03-30"
        },
        "map": "czech-republic/czech-republic-regions.json",
        "description": "The Czech Republic, also known as Czechia, is a landlocked country in Central Europe. Historically known as Bohemia, it is bordered by Austria to the south, Germany to the west, Poland to the northeast, and Slovakia to the southeast.",
        "dateFounded": "1993-01-01",
        "famousFlagPast": "https://www.tresbohemes.com/wp-content/uploads/2018/04/The-Origin-and-Evolution-of-the-Czech-Flag-Tres-Bohemes-1-.png",
        "countryName": "Czech Republic",
        "historyText": "The Duchy of Bohemia was founded in the late 9th century under Great Moravia. It was formally recognized as an Imperial State of the Holy Roman Empire in 1002 and became a kingdom in 1198.[16][17] Following the Battle of Mohács in 1526, the whole Crown of Bohemia was gradually integrated into the Habsburg monarchy. The Protestant Bohemian Revolt led to the Thirty Years' War. After the Battle of White Mountain, the Habsburgs consolidated their rule. With the dissolution of the Holy Empire in 1806, the Crown lands became part of the Austrian Empire.\n\nIn the 19th century, the Czech lands became more industrialized, and in 1918 most of it became part of the First Czechoslovak Republic following the collapse of Austria-Hungary after World War I.[18] Czechoslovakia was the only country in Central and Eastern Europe to remain a parliamentary democracy during the entirety of the interwar period.[19] After the Munich Agreement in 1938, Nazi Germany systematically took control over the Czech lands. Czechoslovakia was restored in 1945 and became an Eastern Bloc communist state following a coup d'état in 1948. Attempts to liberalize the government and economy were suppressed by a Soviet-led invasion of the country during the Prague Spring in 1968. In November 1989, the Velvet Revolution ended communist rule in the country, and on 1 January 1993, Czechoslovakia was dissolved, with its constituent states becoming the independent states of the Czech Republic and Slovakia.\n\nThe Czech Republic is a unitary parliamentary republic and developed country with an advanced, high-income social market economy. It is a welfare state with a European social model, universal health care and free-tuition university education. It ranks 16th in the UN inequality-adjusted human development, 32nd in the Human Development Index and 24th in the World Bank Human Capital Index. It ranks as the 8th safest and most peaceful country and 29th in democratic governance. The Czech Republic is a member of the United Nations, NATO, the European Union, the OECD, the OSCE, and the Council of Europe."
    }
]
```



response Schema

```json
{
  "$schema": "http://json-schema.org/draft-04/schema#",
  "type": "object",
  "properties": {
    "id": {
      "type": "integer"
    },
    "modernFlag": {
      "type": "object",
      "properties": {
        "id": {
          "type": "integer"
        },
        "creator": {
          "type": "string"
        },
        "description": {
          "type": "string"
        },
        "flagPhoto": {
          "type": "string"
        },
        "dateUsed": {
          "type": "string"
        }
      },
      "required": [
        "id",
        "creator",
        "description",
        "flagPhoto",
        "dateUsed"
      ]
    },
    "map": {
      "type": "string"
    },
    "description": {
      "type": "string"
    },
    "dateFounded": {
      "type": "string"
    },
    "famousFlagPast": {
      "type": "string"
    },
    "countryName": {
      "type": "string"
    },
    "historyText": {
      "type": "string"
    }
  },
  "required": [
    "id",
    "modernFlag",
    "map",
    "description",
    "dateFounded",
    "famousFlagPast",
    "countryName",
    "historyText"
  ]
}
```

GET /api/countries/{countryId}/questions
returns 200 if success or 400 if failed


example response 

```json
[
    {
        "Id": 1,
        "Question": "What language do they speak in France ?",
        "Answer": "French",
        "FakeAnswerOne": "German",
        "FakeAnswerTwo": "Joile",
        "FakeAnswerThree": "English",
        "country": {
            "id": 1,
            "countryName": "France",
            "description": "France, in Western Europe, encompasses medieval cities, alpine villages and Mediterranean beaches. Paris, its capital, is famed for its fashion houses, classical art museums including the Louvre and monuments like the Eiffel Tower.",
            "dateFounded": "1872-09-22",
            "famousFlagPast": "https://frenchmoments.eu/wp-content/uploads/2015/05/French-Flag-before-1790.png",
            "map": "france/fr-departments.json",
            "history": "Inhabited since the Palaeolithic era, the territory of Metropolitan France was settled by Celtic tribes known as Gauls during the Iron Age. Rome annexed the area in 51 BC, leading to a distinct Gallo-Roman culture that laid the foundation of the French language. The Germanic Franks formed the Kingdom of Francia, which became the heartland of the Carolingian Empire. The Treaty of Verdun of 843 partitioned the empire, with West Francia becoming the Kingdom of France in 987. In the High Middle Ages, France was a powerful but highly decentralised feudal kingdom. Philip II successfully strengthened royal power and defeated his rivals to double the size of the crown lands; by the end of his reign, France had emerged as the most powerful state in Europe. From the mid-14th to the mid-15th century, France was plunged into a series of dynastic conflicts involving England, collectively known as the Hundred Years' War, and a distinct French identity emerged as a result. The French Renaissance saw art and culture flourish, conflict with the House of Habsburg, and the establishment of a global colonial empire, which by the 20th century would become the second-largest in the world.[15] The second half of the 16th century was dominated by religious civil wars between Catholics and Huguenots that severely weakened the country. France again emerged as Europe's dominant power in the 17th century under Louis XIV following the Thirty Years' War.[16] Inadequate economic policies, inequitable taxes and frequent wars (notably a defeat in the Seven Years' War and costly involvement in the American War of Independence) left the kingdom in a precarious economic situation by the end of the 18th century. This precipitated the French Revolution of 1789, which overthrew the Ancien Régime and produced the Declaration of the Rights of Man, which expresses the nation's ideals to this day.\n\nFrance reached its political and military zenith in the early 19th century under Napoleon Bonaparte, subjugating much of continental Europe and establishing the First French Empire. The French Revolutionary and Napoleonic Wars shaped the course of European and world history. The collapse of the empire initiated a period of relative decline, in which France endured a tumultuous succession of governments until the founding of the French Third Republic during the Franco-Prussian War in 1870. Subsequent decades saw a period of optimism, cultural and scientific flourishing, as well as economic prosperity, known as the Belle Époque. France was one of the major participants of World War I, from which it emerged victorious at a great human and economic cost. It was among the Allied powers of World War II but was soon occupied by the Axis in 1940. Following liberation in 1944, the short-lived Fourth Republic was established and later dissolved in the course of the Algerian War. The current Fifth Republic was formed in 1958 by Charles de Gaulle. Algeria and most French colonies became independent in the 1960s, with the majority retaining close economic and military ties with France.\n\nFrance retains its centuries-long status as a global centre of art, science and philosophy. It hosts the fifth-largest number of UNESCO World Heritage Sites and is the world's leading tourist destination, receiving over 89 million foreign visitors in 2018.[17] France is a developed country ranked 28th in the Human Development Index, with the world's seventh-largest economy by nominal GDP and tenth-largest by PPP; in terms of aggregate household wealth, it ranks fourth in the world.[18] France performs well in international rankings of education, health care, and life expectancy. It remains a great power in global affairs,[19] being one of the five permanent members of the United Nations Security Council and an official nuclear-weapon state. France is a founding and leading member of the European Union and the Eurozone,[20] as well as a key member of the Group of Seven, North Atlantic Treaty Organization (NATO), Organisation for Economic Co-operation and Development (OECD) and Francophonie.",
            "modernFlag": {
                "id": 1,
                "creator": "Jacques-Louis David Lafayette",
                "description": "A vertical tricolour of blue, white, and red",
                "flagPhoto": "https://upload.wikimedia.org/wikipedia/en/thumb/c/c3/Flag_of_France.svg/1024px-Flag_of_France.svg.png",
                "dateUsed": "1794-02-15"
            }
        }
    },
    {
        "Id": 2,
        "Question": "What is the capital of France ?",
        "Answer": "Paris",
        "FakeAnswerOne": "Berlin",
        "FakeAnswerTwo": "Quebec",
        "FakeAnswerThree": "Brest",
        "country": {
            "id": 1,
            "countryName": "France",
            "description": "France, in Western Europe, encompasses medieval cities, alpine villages and Mediterranean beaches. Paris, its capital, is famed for its fashion houses, classical art museums including the Louvre and monuments like the Eiffel Tower.",
            "dateFounded": "1872-09-22",
            "famousFlagPast": "https://frenchmoments.eu/wp-content/uploads/2015/05/French-Flag-before-1790.png",
            "map": "france/fr-departments.json",
            "history": "Inhabited since the Palaeolithic era, the territory of Metropolitan France was settled by Celtic tribes known as Gauls during the Iron Age. Rome annexed the area in 51 BC, leading to a distinct Gallo-Roman culture that laid the foundation of the French language. The Germanic Franks formed the Kingdom of Francia, which became the heartland of the Carolingian Empire. The Treaty of Verdun of 843 partitioned the empire, with West Francia becoming the Kingdom of France in 987. In the High Middle Ages, France was a powerful but highly decentralised feudal kingdom. Philip II successfully strengthened royal power and defeated his rivals to double the size of the crown lands; by the end of his reign, France had emerged as the most powerful state in Europe. From the mid-14th to the mid-15th century, France was plunged into a series of dynastic conflicts involving England, collectively known as the Hundred Years' War, and a distinct French identity emerged as a result. The French Renaissance saw art and culture flourish, conflict with the House of Habsburg, and the establishment of a global colonial empire, which by the 20th century would become the second-largest in the world.[15] The second half of the 16th century was dominated by religious civil wars between Catholics and Huguenots that severely weakened the country. France again emerged as Europe's dominant power in the 17th century under Louis XIV following the Thirty Years' War.[16] Inadequate economic policies, inequitable taxes and frequent wars (notably a defeat in the Seven Years' War and costly involvement in the American War of Independence) left the kingdom in a precarious economic situation by the end of the 18th century. This precipitated the French Revolution of 1789, which overthrew the Ancien Régime and produced the Declaration of the Rights of Man, which expresses the nation's ideals to this day.\n\nFrance reached its political and military zenith in the early 19th century under Napoleon Bonaparte, subjugating much of continental Europe and establishing the First French Empire. The French Revolutionary and Napoleonic Wars shaped the course of European and world history. The collapse of the empire initiated a period of relative decline, in which France endured a tumultuous succession of governments until the founding of the French Third Republic during the Franco-Prussian War in 1870. Subsequent decades saw a period of optimism, cultural and scientific flourishing, as well as economic prosperity, known as the Belle Époque. France was one of the major participants of World War I, from which it emerged victorious at a great human and economic cost. It was among the Allied powers of World War II but was soon occupied by the Axis in 1940. Following liberation in 1944, the short-lived Fourth Republic was established and later dissolved in the course of the Algerian War. The current Fifth Republic was formed in 1958 by Charles de Gaulle. Algeria and most French colonies became independent in the 1960s, with the majority retaining close economic and military ties with France.\n\nFrance retains its centuries-long status as a global centre of art, science and philosophy. It hosts the fifth-largest number of UNESCO World Heritage Sites and is the world's leading tourist destination, receiving over 89 million foreign visitors in 2018.[17] France is a developed country ranked 28th in the Human Development Index, with the world's seventh-largest economy by nominal GDP and tenth-largest by PPP; in terms of aggregate household wealth, it ranks fourth in the world.[18] France performs well in international rankings of education, health care, and life expectancy. It remains a great power in global affairs,[19] being one of the five permanent members of the United Nations Security Council and an official nuclear-weapon state. France is a founding and leading member of the European Union and the Eurozone,[20] as well as a key member of the Group of Seven, North Atlantic Treaty Organization (NATO), Organisation for Economic Co-operation and Development (OECD) and Francophonie.",
            "modernFlag": {
                "id": 1,
                "creator": "Jacques-Louis David Lafayette",
                "description": "A vertical tricolour of blue, white, and red",
                "flagPhoto": "https://upload.wikimedia.org/wikipedia/en/thumb/c/c3/Flag_of_France.svg/1024px-Flag_of_France.svg.png",
                "dateUsed": "1794-02-15"
            }
        }
    },
    {
        "Id": 3,
        "Question": "What is the national animal of France ?",
        "Answer": "Rooster",
        "FakeAnswerOne": "Cow",
        "FakeAnswerTwo": "Bull",
        "FakeAnswerThree": "Unicorn",
        "country": {
            "id": 1,
            "countryName": "France",
            "description": "France, in Western Europe, encompasses medieval cities, alpine villages and Mediterranean beaches. Paris, its capital, is famed for its fashion houses, classical art museums including the Louvre and monuments like the Eiffel Tower.",
            "dateFounded": "1872-09-22",
            "famousFlagPast": "https://frenchmoments.eu/wp-content/uploads/2015/05/French-Flag-before-1790.png",
            "map": "france/fr-departments.json",
            "history": "Inhabited since the Palaeolithic era, the territory of Metropolitan France was settled by Celtic tribes known as Gauls during the Iron Age. Rome annexed the area in 51 BC, leading to a distinct Gallo-Roman culture that laid the foundation of the French language. The Germanic Franks formed the Kingdom of Francia, which became the heartland of the Carolingian Empire. The Treaty of Verdun of 843 partitioned the empire, with West Francia becoming the Kingdom of France in 987. In the High Middle Ages, France was a powerful but highly decentralised feudal kingdom. Philip II successfully strengthened royal power and defeated his rivals to double the size of the crown lands; by the end of his reign, France had emerged as the most powerful state in Europe. From the mid-14th to the mid-15th century, France was plunged into a series of dynastic conflicts involving England, collectively known as the Hundred Years' War, and a distinct French identity emerged as a result. The French Renaissance saw art and culture flourish, conflict with the House of Habsburg, and the establishment of a global colonial empire, which by the 20th century would become the second-largest in the world.[15] The second half of the 16th century was dominated by religious civil wars between Catholics and Huguenots that severely weakened the country. France again emerged as Europe's dominant power in the 17th century under Louis XIV following the Thirty Years' War.[16] Inadequate economic policies, inequitable taxes and frequent wars (notably a defeat in the Seven Years' War and costly involvement in the American War of Independence) left the kingdom in a precarious economic situation by the end of the 18th century. This precipitated the French Revolution of 1789, which overthrew the Ancien Régime and produced the Declaration of the Rights of Man, which expresses the nation's ideals to this day.\n\nFrance reached its political and military zenith in the early 19th century under Napoleon Bonaparte, subjugating much of continental Europe and establishing the First French Empire. The French Revolutionary and Napoleonic Wars shaped the course of European and world history. The collapse of the empire initiated a period of relative decline, in which France endured a tumultuous succession of governments until the founding of the French Third Republic during the Franco-Prussian War in 1870. Subsequent decades saw a period of optimism, cultural and scientific flourishing, as well as economic prosperity, known as the Belle Époque. France was one of the major participants of World War I, from which it emerged victorious at a great human and economic cost. It was among the Allied powers of World War II but was soon occupied by the Axis in 1940. Following liberation in 1944, the short-lived Fourth Republic was established and later dissolved in the course of the Algerian War. The current Fifth Republic was formed in 1958 by Charles de Gaulle. Algeria and most French colonies became independent in the 1960s, with the majority retaining close economic and military ties with France.\n\nFrance retains its centuries-long status as a global centre of art, science and philosophy. It hosts the fifth-largest number of UNESCO World Heritage Sites and is the world's leading tourist destination, receiving over 89 million foreign visitors in 2018.[17] France is a developed country ranked 28th in the Human Development Index, with the world's seventh-largest economy by nominal GDP and tenth-largest by PPP; in terms of aggregate household wealth, it ranks fourth in the world.[18] France performs well in international rankings of education, health care, and life expectancy. It remains a great power in global affairs,[19] being one of the five permanent members of the United Nations Security Council and an official nuclear-weapon state. France is a founding and leading member of the European Union and the Eurozone,[20] as well as a key member of the Group of Seven, North Atlantic Treaty Organization (NATO), Organisation for Economic Co-operation and Development (OECD) and Francophonie.",
            "modernFlag": {
                "id": 1,
                "creator": "Jacques-Louis David Lafayette",
                "description": "A vertical tricolour of blue, white, and red",
                "flagPhoto": "https://upload.wikimedia.org/wikipedia/en/thumb/c/c3/Flag_of_France.svg/1024px-Flag_of_France.svg.png",
                "dateUsed": "1794-02-15"
            }
        }
    }
]
```

response schema

```json
{
  "$schema": "http://json-schema.org/draft-04/schema#",
  "type": "object",
  "properties": {
    "id": {
      "type": "integer"
    },
    "modernFlag": {
      "type": "object",
      "properties": {
        "id": {
          "type": "integer"
        },
        "creator": {
          "type": "string"
        },
        "description": {
          "type": "string"
        },
        "flagPhoto": {
          "type": "string"
        },
        "dateUsed": {
          "type": "string"
        }
      },
      "required": [
        "id",
        "creator",
        "description",
        "flagPhoto",
        "dateUsed"
      ]
    },
    "map": {
      "type": "string"
    },
    "description": {
      "type": "string"
    },
    "dateFounded": {
      "type": "string"
    },
    "famousFlagPast": {
      "type": "string"
    },
    "countryName": {
      "type": "string"
    },
    "historyText": {
      "type": "string"
    }
  },
  "required": [
    "id",
    "modernFlag",
    "map",
    "description",
    "dateFounded",
    "famousFlagPast",
    "countryName",
    "historyText"
  ]
}
```



PUT /api/countries/{id}/questions
return 200 if it worked or 400 if failed



POST /api/countries/{id}/questions
returns 201 if created or 400 if it failed
