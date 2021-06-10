# RideAlong : Cycle Together

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/RideAlong/master/res/logo.png?token=AOAG3ZJRDBCCTW5HJ4XOAFLAZKJOE" width="auto" height="200" />
<img src="https://raw.githubusercontent.com/Ignema/RideAlong/master/res/ridealong.png?token=AOAG3ZLIJVFAMYDRIXER3JLAZKJXA" width="auto" height="200" />
</p>

## Description

This project's goal is to create a platform where people can make bicycle reservations and specify meetup dates to ride bicycles in groups.

## Instructions

First of all, clone this repository

    git clone https://github.com/Ignema/RideAlong.git

### Running the code locally from source

There are three things that need to be running in order to execute the whole application.

- **Postgres Database** (Make sure you edit *application.properties* with the right credentials so that the backend can detect your database)
- **JDK 11** (An IDE like intellij or eclipse will do the work automatically for you)
   
        # Windows
        gradlew bootRun
        # Linux
        ./gradlew bootRun
- **Node and npm**

        npm install
        npm run dev

### Running the project with containers

If you want to use docker, you can simply run this command

    docker-compose -p ridealong up

## Database Schema

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/RideAlong/master/res/schema.png?token=AOAG3ZKVLL5VJ4N2EJISXHTAZKLE6" />
</p>

## App Overview
### Homepage
<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/RideAlong/master/res/Screenshots/1.png?token=AOAG3ZMFNMTJA2RGXDWLG3TAZKJ54" />
</p>
<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/RideAlong/master/res/Screenshots/2.png?token=AOAG3ZMZAMV6SOUR4ISZDWTAZKKAY" />
</p>
<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/RideAlong/master/res/Screenshots/3.png?token=AOAG3ZMIIGYLMHJKKWTHIQLAZKKCS" />
</p>
<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/RideAlong/master/res/Screenshots/4.png?token=AOAG3ZODJZD32UX5GEU7TOLAZKKFA" />
</p>

### Learn more page

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/RideAlong/master/res/Screenshots/5.png?token=AOAG3ZPOJGAQUU37GDQCMULAZKKJO" />
</p>

### Sign up page

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/RideAlong/master/res/Screenshots/6.png?token=AOAG3ZID4KXJOSA3HK77Z3TAZKKME" />
</p>

### Login page

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/RideAlong/master/res/Screenshots/7.png?token=AOAG3ZOCCMGGVFQ7MB4JNBTAZKKPE" />
</p>

### Dashboard: Meetups View

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/RideAlong/master/res/Screenshots/8.png?token=AOAG3ZMCUY5QBCN7SYJIJ6DAZKKQ4" />
</p>

### Meetup card options

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/RideAlong/master/res/Screenshots/12.png?token=AOAG3ZIXVF6XJVP2YQVOSGDAZKKXY" />
</p>

- **➕ Add Button:** Join meetup
- **🔗 Link Button:** Link to gallery where meetup photos are uploaded. It will often be a link to Google Drive.
- **💭 Chat Button(Coming soon):** Open chat modal to talk with people and discuss information related to the meetup.
- **❓ Question Mark Button:** Check if the meetup has ended or not.
- **🪧 Sign Button:** See the location of the meetup
- **📅 Calendar Button:** See the date of the meetup


### Scheduling a meetup modal

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/RideAlong/master/res/Screenshots/9.png?token=AOAG3ZNQ6ETGG4AZWU6K4OTAZKKUG" />
</p>

### Dashboard: Bicycles View

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/RideAlong/master/res/Screenshots/10.png?token=AOAG3ZKZ4KT75CXAV5OY54TAZKKXM" />
</p>

### Giving your bicycle up for rent modal

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/RideAlong/master/res/Screenshots/11.png?token=AOAG3ZPGOYOSPFX4G5CBPMDAZKKXQ" />
</p>

### Bicycle Card

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/RideAlong/master/res/Screenshots/13.png?token=AOAG3ZNHZSX7WI2WXW5DGL3AZKKX6" />
</p>

- **🖼️ Picture Button:** See the whole picture of the bicycle in a new tab.
- **💳 Credit Card Button:** Check the price of the bicycle for which you can be able to rent it.
- **⏲️ Timer Button:** Know how long you can rent this bicycle (in days quantity)
- **🔒 Lock Button:** Is the bicycle available or not.
- **⚡ Electricity Button:** See the owner's name.

<br>
<br>

## <h1>The Mission of <span style="color: rgb(221, 80, 108); font-size: 1.9rem;">RideAlong</span></h1>

<pre>

This project's aim is to create a tool for cyclists to make their hobbies easier and more engaging. 
We noticed that in our local community, people were using the mobile application WhatsApp to schedule
their meetups. This solution is acceptable in its own right, but we envisioned a better solution to
help them avoid the many problems that they were facing.

When using a regular group, there was a risk of not synchronizing in the time of meetings. This would
lead to some people unable to join because the group has already departured. With our application, by using
a postgres database, a springboot backend, and a svelte UI, we can organize the way people meet up and
help them ensure that nobody is left behind.

Furthermore, this application will enable the creation of many communities at once and make the process of
joining them more open and available. This is a far better solution than creating dozens of WhatsApp groups.

We also thought of people who don't have a bicycle to participate. Our application offers the possibility of
renting bicycles from the community for the community.

We really hope that you like our work, and a special thanks to our supervisor <strong>Mr. Mahmoud Hamlaoui.</strong>

Made with 💖 by some ensias students

</pre>