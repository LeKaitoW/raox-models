﻿![image](https://cloud.githubusercontent.com/assets/18644989/20950225/74d6c50c-bc2f-11e6-91e9-3569d4e3430b.png)
Газ - желтая линия; вода - синяя линия; воздух - голубая линия.

## Постановка задачи
Смоделировать работу котельной в трех режимах:
1. Режим растопки котла;
2. Режим штатной работы котла;
3. Режим пожара в котельной.

Особенности:
- Возможность выбирать разный период опроса системы;
- Единица модельного времени - 1 [с];
- График зависимости температуры прямой и обратной воды от температуры на улице представлен ниже:
![image](https://cloud.githubusercontent.com/assets/18644989/20951178/57f5fbf0-bc35-11e6-871c-e2d39243631b.png)
Выведены соответствующие формулы:
Температура_прямой_воды = 59.28 - 0.99 * Температура_на_улице;
Температура_обратной_воды = 45.04 - 0.54 * Температура_на_улице.

В расчетах используется формула W * t = c * m * ΔТ, где
W - текущая мощность горелки;
t - время, в рамках модели t = 1 [с];
с - удельная теплоемкость воды, с = 4200 [Дж/(кг*°С)];
m - масса нагреваемой воды в котле m = 10 [кг/сек];
ΔТ - разница температур прямой и обратной воды перед котлом [°С].

## Режим растопки котла
По эксплуатационным характеристикам в режиме растопки на котел накладываются следующие ограничения:
- Скорость нагрева прямой воды должна быть ограничена 30 [°С/час];
- Температура обратной воды должна быть желательно не меньше 40 [°С], поэтому для увеличения температуры воды перед котлом используется насос.
- При достижении расчетной температуры прямой воды котел переходит в режим штатной работы

## Режим штатной работы котла
- Насос выключен. 
По эксплуатационным характеристикам в штатном режиме работы на котел накладываются следующие ограничения:
- Максимальная температура прямой воды - 115 [°С];
- Максимальная разность температур прямой и обратной воды - 40 [°С];
- Максимальная мощность котла - 1680 [кВт];
- Максимальная скорость изменения мощности котла - 10 [кВт/с];

## Режим пожара в котельной
### Описание
- Наступление пожара осуществляется с помощью кнопки "Активизировать пожар";
- Отключаются все системы, открывается клапан вывода газа в атмосферу;
- Время ликвидации пожара случайная величина от 1 до 2 часов.