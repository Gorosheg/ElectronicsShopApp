# ElectronicsShopApp [download APK](https://github.com/Gorosheg/ElectronicsShopApp/raw/master/app-debug.apk)

Android приложение онлайн магазина

## Описание

Приложение состоит из трех фрагментов.  

Один из них содержит список товаров, возможность выбора категорий товаров, а также фильтр товаров по цене, марке товара и размеру (иконка фильтра в правом верхнем углу). По клику на любую из позиций товаров можно перейти на следующий экран.

<details> 
<summary>Фото первого экрана</summary>

![Фото первого экрана](https://github.com/Gorosheg/ElectronicsShopApp/blob/master/media/app_screenshot_1.png)

</details>

Второй фрагмент содержит подробное описание товара с его характеристиками и изображениями. Также есть возможность выбора цвета и количества памяти. По клику на корзину можно перейти на следующий экран или по клику на стрелку назад вернуться к предыдущему экрану.

<details> 
<summary>Фото второго экрана</summary>

![Фото второго экрана](https://github.com/Gorosheg/ElectronicsShopApp/blob/master/media/app_screenshot_2.png)

</details>

Третий фрагмент - корзина. Содержит список добавленных в нее элементов(подгружаются с сети) и их стоимость, которая меняется в зависимости от количества товаров в корзине (его можно изменить нажав на соответствующее поле рядом с товаром в списке).

<details> 
<summary>Фото третьего экрана</summary>

![Фото третьего экрана](https://github.com/Gorosheg/ElectronicsShopApp/blob/master/media/app_screenshot_3.png)

</details>

## Стек

- Coroutines
- Retrofit
- MVVM
- Koin
- AdapterDelegates
- Сlean Architecture
- Mutli-Module
