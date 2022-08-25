# boom_arrow
A Minecraft mod for making arrows go boom.

To build this, for the sake of my sanity, I shall list what I did here:

1) Delete everything in C:/Users/<user>/.gradle - let's start clean, particularly if things aren't working first time.
2) Unzip the project into a directory
3) Open it in Intellij
4) From OUTSIDE Intellij, run the following gradle commands:
    - gradlew.bat genIntellijRuns
    - gradlew.bat build
5) Refresh the project in Intellij and hope for the best.
6) Once the above is done, the Intellij Gradle plugin _should_ recognise and allow us to run tasks.

Here I will also list what I've learnt. This'll be basic stuff, probably, but at least I won't forget.

## CREATE NEW ITEM

First, we need a class for registering items (i.e. ModItems). In this class, we need to:
- Set up a DeferredRegister, a sort of list for holding items.
- Do item registrations to this DeferredRegister. Below, I'm creating a new generic item, adding it to the Misc tab and enabling stacks of 64.
- Create a register method that registers all the items added to the DeferredRegister.

```
   public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BoomArrow.MODID);

    public static final RegistryObject<Item> BOOM_ARROW = ITEMS.register("boom_arrow",
            () -> new Item(new Item.Properties()
                    .tab(CreativeModeTab.TAB_MISC)
                    .stacksTo(64)));
                    
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }                    
```

In our main class, we need to:
- Get the IEventBus from Forge
- Register all the items in ModItems
- Register this to the Forge EVENT_BUS

```
     IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
     ModItems.register(modEventBus);
     MinecraftForge.EVENT_BUS.register(this);
```

That's essentially all the code required to put a new item (that doesn't really do anything) into Minecraft. We also need the following resources:

- resources/assets/<mod_name>/
  - lang/en_us.json: a json file that defines the name of the item (in US English)
  ```
  {
    "item.<mod_name>.<item_name>": "Item Name In Game"
  }
  ```
  - models/item/<item_name>.json: a json file that defines what model to use and, in the layer0 key, the name of the texture file to use
  ```
    {
    "parent": "item/generated",
    "textures": {
      "layer0": "<mod_name>:item/<item_name>"
      }
    }
  ```
  - textures/item/<item_name>.png: the PNG texture file
