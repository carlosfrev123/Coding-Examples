import discord
import requests
import os
from discord.ext import commands
from discord.ext.commands import DefaultHelpCommand
import random
from dotenv import load_dotenv 
load_dotenv()

intents = discord.Intents().all()
# bot = commands.Bot(command_prefix="!", intents=intents)

# TOKENS FROM ENV
nasaKEY = os.getenv('NASA_API_KEY')
discTOKEN = os.getenv('DISCORD_TOKEN')

# APOD URL
nasa_apod_url = 'https://api.nasa.gov/planetary/apod'

class CustomHelpCommand(DefaultHelpCommand):
    def get_command_signature(self, command):
        return f'!{command.name} - {command.help}'

    async def send_bot_help(self, mapping):
        help_embed = discord.Embed(title="SpaceBOT Commands", description="What you can do!", color=0x00ff00)
        for cog, commands in mapping.items():
            filtered = await self.filter_commands(commands, sort=True)
            command_signatures = [self.get_command_signature(c) for c in filtered]
            if command_signatures:
                # remove cog name
                help_embed.add_field(name="I offer ...", value="\n".join(command_signatures), inline=False)
        
        channel = self.get_destination()
        await channel.send(embed=help_embed)

bot = commands.Bot(command_prefix="!", intents=intents, help_command=CustomHelpCommand())

# APOD - get nasa image of dat and description
async def get_nasa_image_of_the_day():
    params = {'api_key': nasaKEY}
    response = requests.get(nasa_apod_url, params=params)
    if response.status_code == 200:
        data = response.json()
        # Return a tuple with the image URL and the explanation
        return (data['url'], data['explanation'])
    else:
        return ("Sorry, I couldn't retrieve the image of the day.", "")

@bot.event
async def on_ready():
    print(f"{bot.user.name} has connected to Discord!")

# @bot.command(name='help')
# async def help_command(ctx):
#     help_message = ("I can do many spacey things! Here are my commands:\n"
#                     "!APOD - Get the NASA image of the day and its explanation\n"
#                     "!JOKE - Get a random space joke\n"
#                     "!SPACENAME - Get your space name based on your username\n"
#                     "Just type the command and I'll do the rest!")
#     await ctx.send(help_message)

@bot.command(name='APOD', help='Get the NASA image of the day and its explanation')
async def nasa_image(ctx):
    image_url, explanation = await get_nasa_image_of_the_day()
    await ctx.send(f"{image_url}\n{explanation}")


# SPACE_JOKES ARRAY
space_jokes = [
    "Why did the sun go to school? To get a little brighter!",
    "How do you throw a space party? You planet!",
    "Why don’t aliens eat clowns? Because they taste funny!",
    "What do you call a tick on the moon? A lunatic!",
    "How does a man on the moon get his haircut? Eclipse it!",
    "What kind of music do planets like? Neptunes!",
    "Why did the astronaut break up with his girlfriend? He needed space!",
    "What did the alien say to the cat? Take me to your litter!",
    "Why did Venus have to get an air conditioner? Because Mercury moved in!",
    "What do you call an alien with three eyes? An aliiien!",
    "Why did the cow go to outer space? To see the Milky Way!"
]

@bot.command(name='JOKE', help='Get a random space joke')
async def space_joke(ctx):
    joke = random.choice(space_jokes)
    await ctx.send(joke)

@bot.command(name='SPACENAME', help='Get your space name based on your username')
async def space_name(ctx):
    name = f"{ctx.message.author.name}-tron"
    await ctx.send(f"Your space name is ...... {name}")

bot.run(discTOKEN)
