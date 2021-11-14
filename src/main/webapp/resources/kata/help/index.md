<meta charset="UTF-8">

## Вступление

Игровой demo-сервер доступен так же в интернете 24/7 в целях
ознакомления [http://codenjoy.com/codenjoy-contest](http://codenjoy.com/codenjoy-contest).

Игра с открытым исходным кодом. Для реализации своей игры, исправления
ошибок в текущей и внесения других правок необходимо для начала
[форкнуть проект](https://github.com/codenjoyme/codenjoy).
В корне репозитория есть описание в файле Readme.md - там описано, что делать дальше.

По возникающим вопросам, пиши в [skype alexander.baglay](skype:alexander.baglay)
или на почту [apofig@gmail.com](mailto:apofig@gmail.com).

## В чем суть игры?

Есть масса алгоритмических задач, выстроенных в очередь. Тебе предстоит
на время решать их одна за другой, соревнуясь при этом с коллегами.
Для этого ты будешь писать своего бота, решающего все эти головоломки.
Каждый играет на своем собственном поле.

Побеждает игрок с большим числом очков (до условленного времени).
Очки засчитываются за каждый пройденный тест (очки-подбодряшки)
и за решение всей головоломки целиком. Чем быстрее решается
головоломка, тем больше очков получает игрок. 

Игра идет на время, между алгоритмами можно делать
передышку, а очки подсчитываются в зависимости от сложности
алгоритма и времени, затраченного на решение.

Важно! Проверочные тесты появляются один за другим по мере правильного
ответа на них. Если ответ дан неправильно, новый тест не появится, пока
игрок не исправит свой алгоритм. 

Когда все тесты на сервере исчерпаются, игрок перейдет
в режим ожидания - таймер выключается. По готовности,
игрок может запустить следующую головоломку командой message('StartNextLevel') - при этом
запустится таймер и время пойдет. Если игрок захочет пропустить головоломку -
достаточно отправить команды message('SkipThisLevel'). Внимание, пропущенный уровень
нельзя вернуть обратно.

Узнать описание головоломки можно кликнув на поле Level:N, расположенное
под именем игрока над полем. Откроется alert с описанием головоломки.

Нумерация головоломок идет от 0, и самая первая головоломка реализована для
проверки подключения клиента к серверу. За ее прохождение очков не начисляется.

Игра с открытым исходным кодом - для реализации своего алгоритма-головоломки
необходимо реализовать интерфейс CodingDojo\games\kata\src\main\java\com\codenjoy\dojo\kata\model\levels\Level.javа
и разместить его рядом в пакете algorithms. Форкнуть проект <a href="https://github.com/codenjoyme/codenjoy">можно тут</a>
Далее стоит проследовать в Readme.md и прочитать инструкции.

## Подключение к серверу

Итак, игрок [регистрируется на сервере](../../../register?gameName=kata),
указывая свой email.

Далее необходимо подключиться [из кода](../../../resources/kata/user/clients.zip)
к серверу через websocket. Это Maven проект и он подойдет для игры на языках JVM.
Также доступны клиенты .Net и JavaScript. Как запустить клиент - смотри в корне файл README.txt

Для других языков придется написать свой клиент (а после пошарить с нами на почту: [apofig@gmail.com](mailto:apofig@gmail.com))

Адрес для подключения к игре на сервере http://codenjoy.com:

`ws://codenjoy.com:80/codenjoy-contest/ws?user=[user]&code=[code]`

Адрес для подключения к игре на сервере, развернутом в локальной сети:

`ws://[server]:8080/codenjoy-contest/ws?user=[user]&code=[code]`

Тут `[server]` - ip-адрес сервера, `[user]` - id игрока, a `[code]` -
твой security token, его ты можешь получить из адресной
строки браузера после регистрации/логина.

## Формат сообщений

После подключения клиент будет регулярно (каждую секунду) получать JSON
c информацией о текущем состоянии игры.Формат таков

<pre>{
'description':'Описание головоломки.',
'history':[
{
'answer':'answer1',
'question':'question1',
'valid':true
},
{
'answer':'answer1',
'question':'question2',
'valid':true
}
],
'level':0,
'nextQuestion':'question3',
'questions':[
'question1',
'question2',
'question3'
]
}</pre>

Для JVM/JS/.Net клиентов в чистом виде с таким JSON работать не придется.
Детальнее смотри в файле README.txt в корне проекта.

Игра пошаговая, каждую секунду сервер посылает твоему клиенту (боту)
вопросы по активным на текущий момент тестам и ожидает ответов.
За следующую секунду игрок должен успеть дать этот ответ.
Если не успел — не беда, ничего не произойдет и сервер повторит свои вопросы.

Ответы даются командой message, ее формат таков, что на каждый вопрос в input JSON надо
дать ответ. Все ответы запаковываются в массив (см. ниже). Пропускать вопросы не стоит -
порядок их должен соответствовать порядку вопросов в input JSON.

<pre>
message('['answer1','answer2','answer3']')
</pre>

Первостепенная задача – написать websocket клиента, который подключится к серверу.
Затем заставить сервер принимать ответы клиента. Таким образом, игрок подготовится
к основной игре. Основная цель – вести осмысленную игру и победить.