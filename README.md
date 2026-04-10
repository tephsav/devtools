# DevTools Project

## Технологический стек проекта

### Языки и платформы
- **Java 25 LTS** — основной язык разработки
- **Gradle 8.x** — система сборки (через Gradle Wrapper)

### Инструменты качества кода
- **Checkstyle** — статический анализ стиля кода
  - Конфигурация: `config/checkstyle/checkstyle.xml`
  - Запуск: `./gradlew checkstyleMain`
- **JUnit 5** — фреймворк тестирования
  - Запуск: `./gradlew test`

### CI/CD
- **GitHub Actions** — автоматическая проверка PR
  - Checkstyle на каждый коммит
  - Тесты на каждый коммит
  - Конфигурация: `.github/workflows/`

### Правила кода
- Стиль: Google Java Style Guide (через Checkstyle)
- Коммиты: Conventional Commits (`feat:`, `fix:`, `docs:`)
- Ветки: `feature/DVT-X` для задач, `master` — основная
- Pull Request: обязателен для слияния в master

[![Java CI](https://github.com/tephsav/devtools/actions/workflows/ci.yml/badge.svg)](https://github.com/tephsav/devtools/actions/workflows/ci.yml)

Описание проекта...

# Quick Start
Run:
* Gradle → devtools → Tasks → application → run
* Run Anything (Ctrl + Ctrl) → gradle run

Test
* Gradle → devtools → Tasks → verification → test
* Run Anything (Ctrl + Ctrl) → gradle test

# Packages
Package — это группировка классов, предназначенная для конфликта имен и упрощения навигации.  
Объявление "package ru.mentee.power;" говорит, что данный класс принадлежит пространству имён "ru.mentee.power" и находится в папке "src/main/java/ru/mentee/power/".  
Ограничения: Структура папок должна точно повторять имя пакета: если в коде написано package ru.mentee.power, файл обязан лежать в src/main/java/ru/mentee/power/, иначе компилятор выдаст ошибку.

# Таблица переменных/полей
* menteeName — имя студента (String)
* sprintNumber — номер спринта (int)
* plannedHoursPerWeek — запланированные часы (int)
* readyForSprint() — правило, готов ли студент к спринту (если студент запланировал >= 3 часов на спринт)

# Ссылка на урок
https://mentee-power.xl.ru/learn/MCIneBj4KkyH-GIRCspFvA/theory

# Правило веток: feature/DVT-X» с примерами master и feature/DVT-3
* Ветку master оставляем чистым
* Работу ведём в ветке feature/DVT-<номер>

# Git локальный цикл: шаги и команды
1. Создание ветки (git branch feature/DVT-X)
2. Переключение ветки (git checkout feature/DVT-X)
3. Коммит (git commit -m "comments")

# Правило «git status clean»:
<pre>
1. Выявлен мусор — обновить .gitignore, затем сделать git status — не будет показывать лишние файлы как «готовые к коммиту».
2. Мусор уже в индексе — git rm --cached и коммит «Очистить репозиторий».
3. Когда запускаю git check-ignore -v для тестовых путей (например .idea/workspace.xml), команда показывает соответствующий паттерн из .gitignore.
4. Изменения делать в отдельном коммите, не связанным с функциональными изменениями.	
</pre>

## Сценарий ручной проверки DVT-6

### Запуск приложения
1. Откройте Gradle Tool Window (View → Tool Windows → Gradle)
2. Выполните: devtools → Tasks → application → run
3. Ожидаемый вывод в Run Tool Window:
   Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков

### Запуск тестов
1. Откройте Gradle Tool Window
2. Выполните: devtools → Tasks → verification → test
3. Ожидаемый вывод: BUILD SUCCESSFUL, все тесты зелёные

### Отладка через Debug
1. Установите breakpoint на строке цикла while в ProgressTracker.calculateProgress
2. Запустите Debug: кликните правой кнопкой на main → Debug 'ProgressTracker.main()'
3. Используйте Step Over (F8) для прохождения итераций
4. Проверьте Variables: counter, remainingHours должны изменяться корректно
5. Используйте Evaluate Expression (Alt+F8): вычислите remainingLessons * 2
6. Ожидаемый результат Evaluate: 14 (для completedLessons=5, totalLessons=12)

### Что делать при ошибках
- Если вывод некорректен: проверьте логику цикла через Debug
- Если тесты красные: откройте вывод теста, найдите AssertionError, скорректируйте метод
- Если Debug не останавливается: убедитесь, что breakpoint установлен (красный кружок)

## Кодстайл-гайд проекта devtools

Проект следует правилам Google Java Style Guide с адаптацией.
Автоматическая проверка: ./gradlew checkstyleMain

### 1. Именование методов: camelCase

До:    public void add_student(Student s) { }
После: public void addStudent(Student student) { }

Почему: Java Convention требует camelCase для методов.
Источник: https://google.github.io/styleguide/javaguide.html#s5.3-camel-case

### 2. Пробелы после if/for/while

До:    if(condition){
После: if (condition) {

Почему: улучшает читаемость, отделяет ключевое слово от выражения.
Источник: Oracle Code Conventions — Whitespace

### 3. Длина строки: максимум 120 символов

До:    public List getStudentsFromSpecificCityWithVeryLongName...
После: public List getStudentsByCity(String city) {

Почему: длинные строки затрудняют чтение в редакторе и при code review.
Источник: https://google.github.io/styleguide/javaguide.html#s4.4-column-limit

### 4. Порядок импортов

До:    import java.util.List; import java.util.ArrayList; import java.io.File;
После: import java.io.File; import java.util.ArrayList; import java.util.List;

Почему: алфавитный порядок упрощает поиск импортов.
Источник: IntelliJ IDEA → Code → Optimize Imports

### 5. Фигурные скобки для if

До:    if (condition) doSomething();
После: if (condition) { doSomething(); }

Почему: скобки обязательны даже для однострочных блоков.
Источник: https://google.github.io/styleguide/javaguide.html#s4.1.1-braces-always-used

# CI-пайплайн настроен


## Информационный поиск — результаты DVT-11

### Запросы и источники

| № | Запрос | Операторы | Официальный источник                                                                                                                              | Альтернатива | Статус | Дата проверки |
|---|--------|-----------|---------------------------------------------------------------------------------------------------------------------------------------------------|--------------|------|----------|
| 1 |Lombok Gradle Short|site:https://search.maven.org/ "lombok" OR site:https://mvnrepository.com/ "lombok"| https://central.sonatype.com/artifact/de.lars-sh/lombok-annotations/1.18.44|https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.44|200 OK|07.04.2026|
| 2 |Java Stream API|site:https://docs.oracle.com/ "stream api" intitle:api java 25 filetype:*<br>site:https://www.baeldung.com/ "stream api" intitle:api java 25| https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/stream/package-summary.html|https://www.baeldung.com/java-8-streams (Java 8)|200 OK|07.04.2026|
| 3 |горячие клавиши IntelliJ IDEA|site:www.jetbrains.com/help "keymap" "intellij idea"<br>site:https://www.jetbrains.com/ "keymap" "intellij idea" filetype:pdf|https://www.jetbrains.com/help/idea/settings-keymap.html|https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf|200 OK|07.04.2026|

### AI-промпты и сравнение ассистентов

#### Промпт 1: План решения

**Задача:** Нужно добавить валидацию email в класс Student  
**Контекст:** Java 25, у меня есть класс Student с полем email (String), проект на Gradle  
**Ограничения:** без использования регулярных выражений на данном этапе, простая проверка наличия @ и точки  
**Ожидаемый результат:** план из 3-5 шагов, объяснение "почему именно так", НЕ пиши код — я реализую сам  
**Критерии успеха:** валидация отклоняет пустые строки, строки без @, строки без точки после @

**AI-1 ([ChatGPT]):**  
1. Определи точку контроля  
Валидация должна выполняться при создании или изменении объекта (конструктор и/или setter).  
Почему: инвариант объекта фиксируется сразу; объект не может существовать в невалидном состоянии.
2. Введи базовые проверки на пустоту  
Проверь null и пустую строку (включая строки из пробелов).  
Почему: это отдельный класс ошибок, не связанный с форматом email; их нужно отсечь до структурной проверки.
3. Проверь наличие @ и его позицию  
Убедись, что символ @ существует и не является первым или последним символом.  
Почему: email логически делится на локальную часть и домен; отсутствие или крайнее положение @ делает строку некорректной.
4. Проверь наличие точки после @  
Найди позицию @, затем проверь, что после него есть . и он не является последним символом.  
Почему: доменная часть должна содержать хотя бы один уровень (например, domain.com), иначе адрес неполный.
5. Сигнализируй об ошибке через исключение  
При любой неудачной проверке выбрасывай исключение (например, IllegalArgumentException).  
Почему: это fail-fast подход; ошибка фиксируется сразу и не распространяется дальше по системе.

**AI-2 ([DeepSeek]):**  
Вот план действий для добавления простой валидации email в класс Student (без регулярок, только проверка @ и точки после неё).

Шаг 1. Определите контракт валидации  
Решите, где и как будет вызываться проверка. Лучше всего — в сеттере поля email (или в конструкторе, если поле неизменяемое). Валидация должна возвращать boolean или выбрасывать исключение (например, IllegalArgumentException).  
Почему: сеттер — естественное место для контроля данных, поступающих в объект. Это централизует правило и не даст создать студента с некорректным email.

Шаг 2. Отбросьте пустые и null-значения (если применимо)  
Сначала проверьте, что строка не null и не пустая (""). Если пришла пустая строка или null — сразу признавайте email невалидным.  
Почему: пустая строка не может содержать ни @, ни точки, а null вызовет NullPointerException при вызове строковых методов. Это базовая защита.

Шаг 3. Проверьте наличие символа @  
Убедитесь, что в строке есть хотя бы один символ '@'. Используйте метод indexOf('@'). Если символ отсутствует (результат -1) — валидация не пройдена.  
Почему: @ — обязательный разделитель локальной части и домена. Без него строка заведомо не является email-адресом.

Шаг 4. Проверьте наличие точки после @  
Найдите позицию первого @ (индекс atIndex). Затем проверьте, есть ли символ '.' в подстроке после этого индекса: indexOf('.', atIndex + 1) != -1. Если точки нет — отклоняйте.  
Почему: точка в доменной части необходима для указания домена верхнего уровня (например, .com, .ru). Проверка именно «после @» гарантирует, что точка не попала в локальную часть (хотя локальная часть может содержать точку, но без регулярки мы упрощаем).

Шаг 5. (Опционально, но рекомендую) Добавьте минимальные проверки на пустоту сегментов  
Убедитесь, что после @ перед точкой есть хотя бы один символ (имя домена), и после точки — хотя бы один символ (домен верхнего уровня). Например, "a@.ru" или "a@b." должны быть отклонены.  
Почему: формально точка есть, но реальный email так выглядеть не может. Эта проверка не требует регулярки, только анализ индексов и длины строки. Она делает валидацию чуть надёжнее без усложнения.

После реализации всех шагов — протестируйте на граничных случаях: "", "user@", "user@domain", "user@domain.", "user@.com", "user@domain.c". Убедитесь, что проходит только "user@domain.com" и подобные корректные (по вашим правилам) адреса.


**Сравнение:**  
Совпадение:
* одинаковый набор и порядок действий  
  * определение места выполнения валидации email
  * проверка на null и пустую строку
  * проверка на наличие @
  * проверка на наличие точки после @  

Отличие:
  * ChatGPT в случае неудачной проверки предложил выбрасывать исключение, DeepSeek предложил протестировать граничные случае и принимать только корректные адреса.  

Выбор:
  * комбинированный подход, т.к. присутствуют тесты (граничные случаи) и происходит исключение (при некорректном значении)



#### Промпт 2: Проверка кода

**Код для проверки:**
```java
public String calculateTotalProgress(Mentee[] mentees) {
    if (mentees == null || mentees.length == 0) {
        return "Массив пустой";
    }

    int totalCompleted = 0;
    int totalTotal = 0;
    int index = 0;

    while (index < mentees.length) {
        totalCompleted += mentees[index].completedLessons();
        totalTotal += mentees[index].totalLessons();
        index++;
    }

    int totalRemaining = totalTotal - totalCompleted;

    return String.format("Суммарно: пройдено %d из %d уроков, осталось %d уроков",
            totalCompleted, totalTotal, totalRemaining);
}
```

**Что проверить:**
1. Логические ошибки
2. Соответствие Code Conventions
3. Производительность

**AI-1 ([ChatGPT]):**
1. Логические ошибки  
    – Нет проверки элементов массива на `null`  
    При наличии `null` внутри массива произойдет `NullPointerException` при вызове методов.  
    – Нет проверки согласованности данных  
    [Предположение] `completedLessons()` может вернуть значение больше `totalLessons()`. Тогда `totalRemaining` станет отрицательным.  
    – Жестко зашит текст ответа  
    Метод одновременно считает и форматирует строку. Это смешение логики и представления.  
2. Соответствие Code Conventions  
    – Использование while с индексом  
    Для массивов в Java предпочтителен for-each. Текущий вариант увеличивает когнитивную нагрузку без выгоды.  
    – Имя totalTotal  
    Плохая читаемость. Дублирование смысла. Нарушение принципа ясности имен.  
    – Магическая строка  
    Строка результата захардкожена внутри метода. Нет выноса в константу.  
    – Отсутствие JavaDoc  
    Метод не документирован: не описано поведение при null, пустом массиве, некорректных данных.  
    – Язык  
    Метод возвращает строку на русском. В кодовой базе обычно используется один язык (чаще английский). Несогласованность.  
3. Производительность  
    – Алгоритм O(n) — оптимален  
    Один проход по массиву. Улучшать нечего.  
    – `String.format`  
    Медленнее, чем конкатенация или `StringBuilder`.  
    [Вывод] разница незначительна при малых объемах данных. Узким местом не является.  
    – Повторные вызовы методов  
    `completedLessons()` и `totalLessons()` вызываются по одному разу — корректно. Если методы тяжелые, это уже проблема их реализации, а не текущего кода.  
    
**AI-2 ([DeepSeek]):**

Результаты проверки кода
1. Логические ошибки  
    **Проблема: смешение null и пустого массива**  
    Метод возвращает "Массив пустой" и для null, и для массива длины 0. Это логически некорректно: null — это отсутствие массива (ошибка вызова), а пустой массив — допустимый сценарий (нет подопечных). Следует разделить обработку:
    * Для null — бросить IllegalArgumentException (раннее обнаружение ошибки).  
    * Для mentees.length == 0 — вернуть осмысленную строку, например "Нет подопечных".  

    **Потенциальная проблема: отрицательный остаток**  
    Если у какого-то Mentee значение completedLessons() превышает totalLessons() (например, из-за ошибки в бизнес-логике), то totalRemaining станет отрицательным. Метод этого не проверяет. Рекомендуется либо гарантировать корректность данных на входе, либо добавить защитную проверку (например, Math.max(0, totalTotal - totalCompleted)).

    **Строка возврата при пустом массиве**
    При пустом массиве totalCompleted = 0, totalTotal = 0, totalRemaining = 0. Метод вернёт:
    "Суммарно: пройдено 0 из 0 уроков, осталось 0 уроков". Это синтаксически верно, но странно с точки зрения предметной области. Лучше явно обработать этот случай отдельно.

2. Соответствие Code Conventions (Java)
    * **Имена и форматирование** — в целом соблюдены: CamelCase, пробелы, расположение скобок.
    * **Рекомендуемые улучшения**:
      * Заменить while на for-each — современный стиль, меньше кода, исключает ошибку с индексом:
      for (Mentee m : mentees) { ... }
      * Добавить final к параметру метода, если он не изменяется (но это не строгое требование).
      * Вынести магическую строку "Суммарно: пройдено %d из %d уроков, осталось %d уроков" в константу класса.

3. Производительность
    * **Асимптотика** — O(n), один проход по массиву, оптимально для такой задачи.
    * **Память** — не создаются промежуточные коллекции, только результирующая строка.
    * **Микрооптимизации не требуются** — использование while или for не влияет на производительность в данном контексте.
    * **Потенциально узкое место** — если метод вызывается очень часто для огромных массивов, можно рассмотреть кэширование прогресса, но это уже уровень архитектуры.

**Итог**  
Основная логическая ошибка — одинаковое поведение для null и пустого массива. Стиль кода хорош, производительность достаточна. Рекомендуется исправить обработку null и добавить защиту от отрицательного остатка.


**Сравнение:**

Совпадение:
* проверка на пустой массив и null
* проблема согласованности данных
* рекомендация заменить while на for-each
* найдена магическая строка
* корректно определена сложность алгоритма O(n)

Отличие:
* ChatGPT заметил в методе смешение логики и представления
* ChatGPT заметил плохо читаемую переменную totalTotal
* ChatGPT заметил отсутствие Javadoc для поведения при null или пустом методе
* ChatGPT заметил несогласованность языков
* ChatGPT предложил микрооптимизации
* DeepSeek предложил добавить final к параметру метода, если он не изменяется.

Что оказалось наиболее полезным:
* Разделение null и пустого массива
* Согласованность данных (completed > total)
* Осмысленные имена переменных
* Разделение логики и представления




## Личный глоссарий терминов Dev Tools

### Категория: Java-экосистема

#### JDK — Java Development Kit

**Определение:** Development environment for building applications using the Java programming language. Includes compiler (javac), archiver (jar), documentation generator (javadoc), and other tools.

**Контекст использования:** JDK необходим для компиляции Java-кода в байт-код и создания исполняемых JAR-файлов. Без JDK невозможно собрать Java-проект.

**Пример:** После установки JDK выполняем `java -version` для проверки версии. В IntelliJ IDEA настраиваем Project SDK: File → Project Structure → Project → SDK → выбираем JDK 25.

**Источник:** https://docs.oracle.com/en/java/javase/21/docs/

---

#### JRE — Java Runtime Environment

**Определение:** Runtime environment that provides libraries and JVM required to run Java applications.

**Контекст использования:** Используется для запуска Java-программ без инструментов разработки.

**Пример:** запускаем команду `java Main`, где Main — это имя Java-класса, содержащего точку входа в программу.

**Источник:** https://docs.oracle.com/javase/8/docs/

---

#### JVM — Java Virtual Machine

**Определение:** Virtual machine that executes Java bytecode and enables platform independence.

**Контекст использования:** Выполняет байт-код, созданный компилятором Java.

**Пример:** Запуск `.class` файла через JVM.

**Источник:** https://docs.oracle.com/javase/specs/

---

#### Gradle Wrapper — Gradle Wrapper

**Определение:** Script that allows running a specific Gradle version without requiring global installation.

**Контекст использования:** Обеспечивает одинаковую версию Gradle для всей команды.

**Пример:** Выполняем команду `./gradlew build`

**Источник:** https://docs.gradle.org/current/userguide/gradle_wrapper.html

---

#### Инструмент сборки — Build Tool

**Определение:** Tool that automates compiling, testing, and packaging code.

**Контекст использования:** Используется для автоматизации процесса сборки проекта.

**Пример:** Gradle, Maven.

**Источник:** https://docs.gradle.org/current/userguide/userguide.html

---

#### Зависимость — Dependency

**Определение:** External library required by a project.

**Контекст использования:** Подключается через build tool для расширения функциональности.

**Пример:** `implementation 'org.springframework:spring-core:6.0.0'`. Gradle при сборке автоматически скачивает библиотеку из удалённого репозитория (например, Maven Central), добавляет её в classpath и делает доступной для использования в коде проекта

**Источник:** https://docs.gradle.org/current/userguide/dependency_management_basics.html

---

#### Артефакт — Artifact

**Определение:** Output file produced by a build process (e.g., JAR, WAR).

**Контекст использования:** Используется как финальный результат сборки для передачи между этапами разработки и доставки.

**Пример:** `app.jar`

**Источник:** https://docs.gradle.org/current/userguide/artifact_resolution.html

---

### Категория: Инструменты разработки

#### IDE — Integrated Development Environment

**Определение:** Software application providing tools for development such as editor, debugger, and build automation.

**Контекст использования:** Основная среда разработки.

**Пример:** IntelliJ IDEA, Eclipse, VS Code

**Источник:** https://www.jetbrains.com/help/idea/discover-intellij-idea.html

---

#### SDK — Software Development Kit

**Определение:** Collection of software tools and libraries for developing applications.

**Контекст использования:** Используется для разработки под конкретную платформу.

**Пример:** AWS SDK.

**Источник:** https://aws.amazon.com/what-is/sdk/

---

### Git — Git

**Определение:** Distributed version control system for tracking changes in source code.

**Контекст использования:** Управление версиями проекта.

**Пример:** `git init; git add .; git commit -m "initial commit"`. Инициализация репозитория, добавление файлов в индекс и создание первого коммита, фиксирующего текущее состояние пр

**Источник:** https://git-scm.com/docs/git

---

#### Репозиторий — Repository

**Определение:** Storage location for code and its history.

**Контекст использования:** Хранит проект и историю изменений.

**Пример:** GitHub / GitLab repository.

**Источник:** https://git-scm.com/docs/gitglossary

---

#### Коммит — Commit

**Определение:** Snapshot of changes in the repository.

**Контекст использования:** Фиксирует изменения в истории.

**Пример:** `git commit -m "fix bug"`

**Источник:** https://git-scm.com/docs/git-commit

---

#### Ветка — Branch

**Определение:** Independent line of development.

**Контекст использования:** Используется для изоляции изменений в процессе разработки, что позволяет параллельную работу команды, безопасное внесение изменений и последующее слияние (merge) в основную ветку через Pull Request.

**Пример:** `git checkout -b feature/login`

**Источник:** https://git-scm.com/docs/git-branch

---

#### Pull Request — Pull Request

**Определение:** Request to merge changes from one branch into another.

**Контекст использования:** Используется как механизм интеграции изменений между ветками с обязательной проверкой: code review, автоматические проверки (CI, тесты), обсуждение изменений и контроль перед слиянием в целевую ветку

**Пример:** В системе (GitHub/GitLab) создаётся PR:
* source: feature/login
* target: main

После этого запускаются CI-проверки и code review перед merge.

**Источник:** https://docs.github.com/en/pull-requests

---

#### Checkstyle — Checkstyle

**Определение:** Tool for checking Java code against coding standards.

**Контекст использования:** Контроль качества и стиля кода.

**Пример:** `./gradlew checkstyleMain`

**Источник:** https://checkstyle.sourceforge.io/

---

#### Отладка — Debug

**Определение:** Process of identifying and fixing bugs in code.

**Контекст использования:** Используется для анализа пошагового выполнения программы, позволяет отслеживать поток выполнения, проверять значения переменных, стек вызовов и поведение кода для устранения ошибок.

**Пример:** Запуск Debug в IDE.

**Источник:** https://dev.java/learn/debugging/

---

#### Точка останова — Breakpoint

**Определение:** Marker that pauses program execution during debugging.

**Контекст использования:** Используется для анализа текущего состояния программы (значения переменных, стек вызовов, условия выполнения и поток управления)

**Пример:** Установка breakpoint в IDE.

**Источник:** https://www.jetbrains.com/help/idea/using-breakpoints.html

---

### Категория: Процессы и практики

#### Code Review — Code Review

**Определение:** Systematic examination of code to identify issues and improve quality.

**Контекст использования:** Используется как обязательный этап перед интеграцией изменений в основную ветку: обеспечивает контроль качества кода, выявление дефектов, проверку архитектурных решений, соответствие стандартам и обмен знаниями внутри команды через обсуждение в Pull Request.

**Пример:** Review PR в GitHub.

**Источник:** https://docs.gitlab.com/development/code_review/

---

#### CI/CD — Continuous Integration / Continuous Delivery

**Определение:** Practices for automating integration and delivery of code changes.

**Контекст использования:** Используется для автоматизации полного цикла доставки изменений: сборка, тесты и проверки (CI), разворачивание в средах (CD).

**Пример:** Pipeline автоматически запускается при push или pull request, выполняет сборку проекта, запускает тесты и формирует проверяемый результат перед интеграцией изменений.

**Источник:** https://docs.github.com/en/actions

---

#### Runbook — Runbook

**Определение:** Document describing procedures for handling operations and incidents.

**Контекст использования:** Используется как документация по эксплуатации системы: пошаговые процедуры для обработки инцидентов, диагностики, восстановления сервисов.

**Пример:** Инструкция по восстановлению сервиса.

**Источник:** https://docs.gitlab.com/user/project/clusters/runbooks/

---




## Вопросы по сложным терминам

### Вопрос 1: Gradle Wrapper

**Задача:** Не понимаю, зачем нужен Gradle Wrapper, если можно установить Gradle глобально.

**Контекст:** Изучил документацию Gradle, вижу файлы `gradlew` и `gradlew.bat` в проекте.

**Ограничения:** Пробовал запускать и через `gradle`, и через `gradlew`, разницы не увидел.

**Ожидаемый результат:** Понимание, зачем Wrapper нужен в командной разработке и CI.

**Критерии успеха:** Могу объяснить, почему `./gradlew` предпочтительнее и как он фиксирует версию Gradle.

---

### Вопрос 2: Breakpoint

**Задача:** Не до конца понимаю, как эффективно использовать breakpoints при отладке.

**Контекст:** Использую Debug в IntelliJ IDEA, ставлю breakpoint, но не всегда понимаю, что дальше делать.

**Ограничения:** Пробовал step over и step into, но путаюсь в сложных вызовах.

**Ожидаемый результат:** Чёткое понимание стратегии отладки с breakpoint.

**Критерии успеха:** Могу локализовать баг, используя breakpoint и пошаговое выполнение.