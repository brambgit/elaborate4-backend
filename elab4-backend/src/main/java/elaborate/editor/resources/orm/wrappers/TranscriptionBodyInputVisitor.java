package elaborate.editor.resources.orm.wrappers;

/*
 * #%L
 * elab4-backend
 * =======
 * Copyright (C) 2011 - 2014 Huygens ING
 * =======
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import static nl.knaw.huygens.tei.Traversal.NEXT;
import static nl.knaw.huygens.tei.Traversal.STOP;
import nl.knaw.huygens.tei.DelegatingVisitor;
import nl.knaw.huygens.tei.Element;
import nl.knaw.huygens.tei.ElementHandler;
import nl.knaw.huygens.tei.Traversal;
import nl.knaw.huygens.tei.XmlContext;
import nl.knaw.huygens.tei.handlers.RenderElementHandler;
import nl.knaw.huygens.tei.handlers.XmlTextHandler;
import elaborate.editor.model.orm.Transcription;

public class TranscriptionBodyInputVisitor extends DelegatingVisitor<XmlContext> {
  private static final String TAG_SUP = "sup";
  private static final String TAG_SPAN = "span";
  private static final String ATTR_DATA_MARKER = "data-marker";
  private static final String ATTR_DATA_ID = "data-id";

  public TranscriptionBodyInputVisitor() {
    super(new XmlContext());
    setTextHandler(new XmlTextHandler<XmlContext>());
    setDefaultElementHandler(new RenderElementHandler());
    addElementHandler(new SpanHandler(), TAG_SPAN);
    addElementHandler(new SupHandler(), TAG_SUP);
    addElementHandler(new BrHandler(), "br");
  }

  private static class SpanHandler implements ElementHandler<XmlContext> {
    @Override
    public Traversal enterElement(Element e, XmlContext c) {
      if (isBeginMarker(e)) {
        String id = e.getAttribute(ATTR_DATA_ID);
        Element ab = new Element(Transcription.BodyTags.ANNOTATION_BEGIN);
        ab.setAttribute("id", id);
        c.addEmptyElementTag(ab);
      } else {
        c.addOpenTag(e);
      }
      return NEXT;
    }

    @Override
    public Traversal leaveElement(Element e, XmlContext c) {
      if (!isBeginMarker(e)) {
        c.addCloseTag(TAG_SPAN);
      }
      return NEXT;
    }

    private boolean isBeginMarker(Element e) {
      return "begin".equals(e.getAttribute(ATTR_DATA_MARKER));
    }
  }

  private static class SupHandler implements ElementHandler<XmlContext> {
    @Override
    public Traversal enterElement(Element e, XmlContext c) {
      if (isEndMarker(e)) {
        String id = e.getAttribute(ATTR_DATA_ID);
        Element ae = new Element(Transcription.BodyTags.ANNOTATION_END);
        ae.setAttribute("id", id);
        c.addEmptyElementTag(ae);
        return STOP;
      } else {
        c.addOpenTag(e);
        return NEXT;
      }
    }

    private boolean isEndMarker(Element e) {
      return "end".equals(e.getAttribute(ATTR_DATA_MARKER));
    }

    @Override
    public Traversal leaveElement(Element e, XmlContext c) {
      if (!isEndMarker(e)) {
        c.addCloseTag(TAG_SPAN);
      }
      return NEXT;
    }
  }

  private static class BrHandler implements ElementHandler<XmlContext> {
    @Override
    public Traversal enterElement(Element e, XmlContext c) {
      c.addLiteral("\n");
      return STOP;
    }

    @Override
    public Traversal leaveElement(Element arg0, XmlContext arg1) {
      return NEXT;
    }

  }

}
