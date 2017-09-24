﻿![boiler_room](screenshots/Скриншот.png?raw=true)

Газ - желтая линия; вода - синяя линия; воздух - голубая линия.

## Постановка задачи
Смоделировать работу котельной в трех режимах:
- Режим растопки котла;
- Режим штатной работы котла;
- Режим пожара в котельной.

Особенности:
- Возможность выбирать разный период опроса системы;
- Единица модельного времени - 1 [с];
- Расчетное время моделирования системы 30 [дней] = 2 592 000 [с]
- За расчетное время моделирования среднесуточная температура должна понизиться на 10 [°С];
- График зависимости температуры прямой и обратной воды от температуры на улице представлен ниже:

![boiler_room](screenshots/Температурный_график_котла.png?raw=true)

На основе графика выведены соответствующие формулы:
- Расчетная\_температура\_прямой\_воды = константа\_прямой\_воды\_1 - константа\_прямой\_воды\_2 * Температура\_на\_улице;
- Расчетная\_температура\_обратной\_воды = константа\_обратной\_воды\_1 - константа\_обратной\_воды\_2 * Температура\_на\_улице.

где: 
- константа\_прямой\_воды\_1 = 59.28
- константа\_прямой\_воды\_2 = 0.99
- константа\_обратной\_воды\_1 = 45.04
- константа\_обратной\_воды\_2 = 0.54

В расчетах используется формула W * t = c * m * ΔТ, где:
- W - текущая мощность горелки [Вт];
- t - время, в рамках модели t = 1 [с];
- с - удельная теплоемкость воды, с = 4200 [Дж/(кг*°С)]; 
- m - масса нагреваемой воды в котле, m = 10 [кг/с];
- ΔТ - разница температур прямой и обратной воды перед котлом [°С].

## Режим растопки котла
По эксплуатационным характеристикам в режиме растопки на котел накладываются следующие ограничения:
- Скорость нагрева прямой воды должна быть ограничена 30 [°С/час];
- Температура обратной воды должна быть желательно не меньше 40 [°С], поэтому для увеличения температуры воды перед котлом используется насос;
- При достижении расчетной температуры прямой воды котел переходит в режим штатной работы.

## Режим штатной работы котла
- Насос выключен;
- Существует понятие критической температуры на улице. При таком значении и ниже котел начинает остывать в силу ограниченных эксплуатационных характеристик.

По эксплуатационным характеристикам в штатном режиме работы на котел накладываются следующие ограничения:
- Максимальная температура прямой воды 115 [°С];
- Максимальная разность температур прямой и обратной воды 40 [°С];
- Максимальная мощность котла 1680 [кВт];
- Максимальная скорость изменения мощности котла 10 [кВт/с].

## Режим пожара в котельной
### Описание
- Наступление пожара осуществляется с помощью кнопки "Вызвать пожар";
- Отключаются все системы, открывается клапан вывода газа в атмосферу;
- Время ликвидации пожара случайная величина от 1 часа до 2 дней.