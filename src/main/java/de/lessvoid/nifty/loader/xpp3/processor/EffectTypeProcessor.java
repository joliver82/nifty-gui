package de.lessvoid.nifty.loader.xpp3.processor;

import de.lessvoid.nifty.effects.EffectEventId;
import de.lessvoid.nifty.loader.xpp3.Attributes;
import de.lessvoid.nifty.loader.xpp3.XmlParser;
import de.lessvoid.nifty.loader.xpp3.elements.EffectType;
import de.lessvoid.nifty.loader.xpp3.elements.EffectsType;


/**
 * EffectType.
 * @author void
 */
public class EffectTypeProcessor implements XmlElementProcessor {

  /**
   * EffectEventId.
   */
  private EffectEventId effectEventId;

  /**
   * effects type.
   */
  private EffectsType effectsType;

  /**
   * create.
   * @param effectsTypeParam EffectsType
   * @param effectEventIdParam effectEventIdParam
   */
  public EffectTypeProcessor(final EffectsType effectsTypeParam, final EffectEventId effectEventIdParam) {
    this.effectsType = effectsTypeParam;
    this.effectEventId = effectEventIdParam;
  }

  /**
   * process.
   * @param xmlParser xmlParser
   * @param attributes attributes
   * @throws Exception exception
   */
  public void process(final XmlParser xmlParser, final Attributes attributes) throws Exception {
    EffectType effectType = new EffectType();
    effectType.initFromAttributes(attributes);
    if (effectEventId == EffectEventId.onStartScreen) {
      effectsType.addOnStartScreen(effectType);
    } else if (effectEventId == EffectEventId.onEndScreen) {
      effectsType.addOnEndScreen(effectType);
    } else if (effectEventId == EffectEventId.onClick) {
      effectsType.addOnClick(effectType);
    } else if (effectEventId == EffectEventId.onFocus) {
      effectsType.addOnFocus(effectType);
    } else if (effectEventId == EffectEventId.onHover) {
      effectsType.addOnHover(effectType);
    } else if (effectEventId == EffectEventId.onActive) {
      effectsType.addOnActive(effectType);
    }

    xmlParser.nextTag();
  }
}